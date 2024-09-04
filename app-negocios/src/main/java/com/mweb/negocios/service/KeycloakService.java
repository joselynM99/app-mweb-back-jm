// KeycloakService.java
package com.mweb.negocios.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class KeycloakService {

    @ConfigProperty(name = "quarkus.oidc.auth-server-url")
    String authServerUrl;

    @ConfigProperty(name = "quarkus.oidc.client-id")
    String clientId;

    @ConfigProperty(name = "quarkus.oidc.credentials.secret")
    String clientSecret;

    @ConfigProperty(name = "keycloak.realm")
    String realm;

    private Client client = ClientBuilder.newClient();

    public String createUser(String token, String username, String firstName, String lastName, String email, String password) {
        Map<String, Object> user = new HashMap<>();
        user.put("username", username);
        user.put("firstName", firstName);
        user.put("lastName", lastName);
        user.put("email", email);
        user.put("enabled", true);
        user.put("emailVerified", true);

        Map<String, String> credentials = new HashMap<>();
        credentials.put("type", "password");
        credentials.put("value", password);
        user.put("credentials", new Map[]{credentials});


        String cleanAuthServerUrl = authServerUrl.replaceAll("/realms.*", "");

        Response response = client.target(cleanAuthServerUrl + "/admin/realms/" + realm + "/users")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .post(Entity.json(user));


        if (response.getStatus() == 201) {
            String location = response.getHeaderString("Location");
            return location.substring(location.lastIndexOf("/") + 1);
        } else {
            throw new RuntimeException("Failed to create user");
        }
    }
    public void updateUser(String token, String userId, String username, String firstName, String lastName, String email, String password, boolean activo) {
        Map<String, Object> user = new HashMap<>();
        user.put("username", username);
        user.put("firstName", firstName);
        user.put("lastName", lastName);
        user.put("email", email);
        user.put("enabled", activo);

        Map<String, String> credentials = new HashMap<>();
        credentials.put("type", "password");
        credentials.put("value", password);
        credentials.put("temporary", "false");

        user.put("credentials", new Map[]{credentials});
        String cleanAuthServerUrl = authServerUrl.replaceAll("/realms.*", "");
        Response response = client.target(cleanAuthServerUrl + "/admin/realms/" + realm + "/users/" + userId)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .put(Entity.json(user));

        if (response.getStatus() != 204) {
            throw new RuntimeException("Failed to update user");
        }
    }
// KeycloakService.java
public void assignRole(String token, String userId, String roleName) {
    String cleanAuthServerUrl = authServerUrl.replaceAll("/realms.*", "");

    // Get all roles assigned to the user
    Response response = client.target(cleanAuthServerUrl + "/admin/realms/" + realm + "/users/" + userId + "/role-mappings/realm")
            .request(MediaType.APPLICATION_JSON)
            .header("Authorization", "Bearer " + token)
            .get();

    if (response.getStatus() == 200) {
        List<Map<String, Object>> roles = response.readEntity(List.class);

        // Remove all existing roles
        response = client.target(cleanAuthServerUrl + "/admin/realms/" + realm + "/users/" + userId + "/role-mappings/realm")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .method("DELETE", Entity.json(roles));

        if (response.getStatus() != 204) {
            throw new RuntimeException("Failed to remove existing roles");
        }
    } else {
        throw new RuntimeException("Failed to get existing roles");
    }

    // Get the new role
    response = client.target(cleanAuthServerUrl + "/admin/realms/" + realm + "/roles/" + roleName)
            .request(MediaType.APPLICATION_JSON)
            .header("Authorization", "Bearer " + token)
            .get();

    if (response.getStatus() == 200) {
        Map<String, Object> role = response.readEntity(Map.class);

        // Assign the new role
        response = client.target(cleanAuthServerUrl + "/admin/realms/" + realm + "/users/" + userId + "/role-mappings/realm")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .post(Entity.json(new Map[]{role}));

        if (response.getStatus() != 204) {
            throw new RuntimeException("Failed to assign new role");
        }
    } else {
        throw new RuntimeException("Role not found");
    }
}
}