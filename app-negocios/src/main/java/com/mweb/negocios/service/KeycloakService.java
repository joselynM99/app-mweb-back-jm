// KeycloakService.java
package com.mweb.negocios.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
@Transactional
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

    public String getAdminAccessToken() {
        String tokenUrl = authServerUrl + "/protocol/openid-connect/token";

        Form form = new Form();
        form.param("grant_type", "client_credentials");
        form.param("client_id", clientId);
        form.param("client_secret", clientSecret);

        Response response = client.target(tokenUrl)
                .request(MediaType.APPLICATION_FORM_URLENCODED)
                .post(Entity.form(form));

        if (response.getStatus() == 200) {
            String responseBody = response.readEntity(String.class);
            JsonObject jsonObject = Json.createReader(new StringReader(responseBody)).readObject();
            return jsonObject.getString("access_token");
        } else {
            throw new RuntimeException("Failed to obtain admin access token");
        }
    }

    public String createUser(String username, String firstName, String lastName, String email, String password) {
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

        String token = getAdminAccessToken();

        String cleanAuthServerUrl = authServerUrl.replaceAll("/realms.*", "");

        Response response = client.target(cleanAuthServerUrl + "/admin/realms/" + realm + "/users")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .post(Entity.json(user));

        System.out.println("Response Body: " + response.readEntity(String.class));

        if (response.getStatus() == 201) {
            String location = response.getHeaderString("Location");
            return location.substring(location.lastIndexOf("/") + 1);
        } else {
            throw new RuntimeException("Failed to create user");
        }
    }

    public void updateUser(String userId, String username, String firstName, String lastName, String email, String password, boolean activo) {
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

        String token = getAdminAccessToken();
        user.put("credentials", new Map[]{credentials});
        String cleanAuthServerUrl = authServerUrl.replaceAll("/realms.*", "");
        System.out.println("URL: " + cleanAuthServerUrl + "/admin/realms/" + realm + "/users/" + userId);
        Response response = client.target(cleanAuthServerUrl + "/admin/realms/" + realm + "/users/" + userId)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .put(Entity.json(user));
        System.out.println("Response Body: " + response.readEntity(String.class));
        if (response.getStatus() != 204) {
            throw new RuntimeException("Failed to update user");
        }
    }

    // KeycloakService.java
    public void assignRole(String userId, String roleName) {
        String cleanAuthServerUrl = authServerUrl.replaceAll("/realms.*", "");

        String token = getAdminAccessToken();

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

    public void deleteUser(String userId) {
        String token = getAdminAccessToken();
        String cleanAuthServerUrl = authServerUrl.replaceAll("/realms.*", "");
        Response response = client.target(cleanAuthServerUrl + "/admin/realms/" + realm + "/users/" + userId)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .delete();

        System.out.println("Response code: " + response.getStatus());

        if (response.getStatus() != 204 && response.getStatus() != 200) {
            System.out.println("entrando al error");
            throw new RuntimeException("Failed to delete user");
        }
    }


}