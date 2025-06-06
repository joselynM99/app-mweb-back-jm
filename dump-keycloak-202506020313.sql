PGDMP      !                }            keycloak    16.8    17.0    Z           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            [           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            \           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            ]           1262    24817    keycloak    DATABASE     s   CREATE DATABASE keycloak WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';
    DROP DATABASE keycloak;
                     azure_pg_admin    false                        2615    2200    public    SCHEMA     2   -- *not* creating schema, since initdb creates it
 2   -- *not* dropping schema, since initdb creates it
                     azure_pg_admin    false            ^           0    0 4   FUNCTION pg_replication_origin_advance(text, pg_lsn)    ACL     `   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_advance(text, pg_lsn) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    309            _           0    0 +   FUNCTION pg_replication_origin_create(text)    ACL     W   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_create(text) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    322            `           0    0 )   FUNCTION pg_replication_origin_drop(text)    ACL     U   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_drop(text) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    321            a           0    0 (   FUNCTION pg_replication_origin_oid(text)    ACL     T   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_oid(text) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    314            b           0    0 6   FUNCTION pg_replication_origin_progress(text, boolean)    ACL     b   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_progress(text, boolean) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    315            c           0    0 1   FUNCTION pg_replication_origin_session_is_setup()    ACL     ]   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_session_is_setup() TO azure_pg_admin;
       
   pg_catalog               azuresu    false    316            d           0    0 8   FUNCTION pg_replication_origin_session_progress(boolean)    ACL     d   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_session_progress(boolean) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    317            e           0    0 .   FUNCTION pg_replication_origin_session_reset()    ACL     Z   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_session_reset() TO azure_pg_admin;
       
   pg_catalog               azuresu    false    310            f           0    0 2   FUNCTION pg_replication_origin_session_setup(text)    ACL     ^   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_session_setup(text) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    318            g           0    0 +   FUNCTION pg_replication_origin_xact_reset()    ACL     W   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_xact_reset() TO azure_pg_admin;
       
   pg_catalog               azuresu    false    319            h           0    0 K   FUNCTION pg_replication_origin_xact_setup(pg_lsn, timestamp with time zone)    ACL     w   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_xact_setup(pg_lsn, timestamp with time zone) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    320            i           0    0    FUNCTION pg_show_replication_origin_status(OUT local_id oid, OUT external_id text, OUT remote_lsn pg_lsn, OUT local_lsn pg_lsn)    ACL     �   GRANT ALL ON FUNCTION pg_catalog.pg_show_replication_origin_status(OUT local_id oid, OUT external_id text, OUT remote_lsn pg_lsn, OUT local_lsn pg_lsn) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    311            j           0    0    FUNCTION pg_stat_reset()    ACL     D   GRANT ALL ON FUNCTION pg_catalog.pg_stat_reset() TO azure_pg_admin;
       
   pg_catalog               azuresu    false    307            k           0    0 #   FUNCTION pg_stat_reset_shared(text)    ACL     O   GRANT ALL ON FUNCTION pg_catalog.pg_stat_reset_shared(text) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    308            l           0    0 4   FUNCTION pg_stat_reset_single_function_counters(oid)    ACL     `   GRANT ALL ON FUNCTION pg_catalog.pg_stat_reset_single_function_counters(oid) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    313            m           0    0 1   FUNCTION pg_stat_reset_single_table_counters(oid)    ACL     ]   GRANT ALL ON FUNCTION pg_catalog.pg_stat_reset_single_table_counters(oid) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    312            n           0    0    COLUMN pg_config.name    ACL     D   GRANT SELECT(name) ON TABLE pg_catalog.pg_config TO azure_pg_admin;
       
   pg_catalog               azuresu    false    98            o           0    0    COLUMN pg_config.setting    ACL     G   GRANT SELECT(setting) ON TABLE pg_catalog.pg_config TO azure_pg_admin;
       
   pg_catalog               azuresu    false    98            p           0    0 $   COLUMN pg_hba_file_rules.line_number    ACL     S   GRANT SELECT(line_number) ON TABLE pg_catalog.pg_hba_file_rules TO azure_pg_admin;
       
   pg_catalog               azuresu    false    94            q           0    0    COLUMN pg_hba_file_rules.type    ACL     L   GRANT SELECT(type) ON TABLE pg_catalog.pg_hba_file_rules TO azure_pg_admin;
       
   pg_catalog               azuresu    false    94            r           0    0 !   COLUMN pg_hba_file_rules.database    ACL     P   GRANT SELECT(database) ON TABLE pg_catalog.pg_hba_file_rules TO azure_pg_admin;
       
   pg_catalog               azuresu    false    94            s           0    0 "   COLUMN pg_hba_file_rules.user_name    ACL     Q   GRANT SELECT(user_name) ON TABLE pg_catalog.pg_hba_file_rules TO azure_pg_admin;
       
   pg_catalog               azuresu    false    94            t           0    0     COLUMN pg_hba_file_rules.address    ACL     O   GRANT SELECT(address) ON TABLE pg_catalog.pg_hba_file_rules TO azure_pg_admin;
       
   pg_catalog               azuresu    false    94            u           0    0     COLUMN pg_hba_file_rules.netmask    ACL     O   GRANT SELECT(netmask) ON TABLE pg_catalog.pg_hba_file_rules TO azure_pg_admin;
       
   pg_catalog               azuresu    false    94            v           0    0 $   COLUMN pg_hba_file_rules.auth_method    ACL     S   GRANT SELECT(auth_method) ON TABLE pg_catalog.pg_hba_file_rules TO azure_pg_admin;
       
   pg_catalog               azuresu    false    94            w           0    0     COLUMN pg_hba_file_rules.options    ACL     O   GRANT SELECT(options) ON TABLE pg_catalog.pg_hba_file_rules TO azure_pg_admin;
       
   pg_catalog               azuresu    false    94            x           0    0    COLUMN pg_hba_file_rules.error    ACL     M   GRANT SELECT(error) ON TABLE pg_catalog.pg_hba_file_rules TO azure_pg_admin;
       
   pg_catalog               azuresu    false    94            y           0    0 ,   COLUMN pg_replication_origin_status.local_id    ACL     [   GRANT SELECT(local_id) ON TABLE pg_catalog.pg_replication_origin_status TO azure_pg_admin;
       
   pg_catalog               azuresu    false    144            z           0    0 /   COLUMN pg_replication_origin_status.external_id    ACL     ^   GRANT SELECT(external_id) ON TABLE pg_catalog.pg_replication_origin_status TO azure_pg_admin;
       
   pg_catalog               azuresu    false    144            {           0    0 .   COLUMN pg_replication_origin_status.remote_lsn    ACL     ]   GRANT SELECT(remote_lsn) ON TABLE pg_catalog.pg_replication_origin_status TO azure_pg_admin;
       
   pg_catalog               azuresu    false    144            |           0    0 -   COLUMN pg_replication_origin_status.local_lsn    ACL     \   GRANT SELECT(local_lsn) ON TABLE pg_catalog.pg_replication_origin_status TO azure_pg_admin;
       
   pg_catalog               azuresu    false    144            }           0    0     COLUMN pg_shmem_allocations.name    ACL     O   GRANT SELECT(name) ON TABLE pg_catalog.pg_shmem_allocations TO azure_pg_admin;
       
   pg_catalog               azuresu    false    99            ~           0    0    COLUMN pg_shmem_allocations.off    ACL     N   GRANT SELECT(off) ON TABLE pg_catalog.pg_shmem_allocations TO azure_pg_admin;
       
   pg_catalog               azuresu    false    99                       0    0     COLUMN pg_shmem_allocations.size    ACL     O   GRANT SELECT(size) ON TABLE pg_catalog.pg_shmem_allocations TO azure_pg_admin;
       
   pg_catalog               azuresu    false    99            �           0    0 *   COLUMN pg_shmem_allocations.allocated_size    ACL     Y   GRANT SELECT(allocated_size) ON TABLE pg_catalog.pg_shmem_allocations TO azure_pg_admin;
       
   pg_catalog               azuresu    false    99            �           0    0    COLUMN pg_statistic.starelid    ACL     K   GRANT SELECT(starelid) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.staattnum    ACL     L   GRANT SELECT(staattnum) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stainherit    ACL     M   GRANT SELECT(stainherit) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stanullfrac    ACL     N   GRANT SELECT(stanullfrac) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stawidth    ACL     K   GRANT SELECT(stawidth) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stadistinct    ACL     N   GRANT SELECT(stadistinct) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stakind1    ACL     K   GRANT SELECT(stakind1) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stakind2    ACL     K   GRANT SELECT(stakind2) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stakind3    ACL     K   GRANT SELECT(stakind3) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stakind4    ACL     K   GRANT SELECT(stakind4) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stakind5    ACL     K   GRANT SELECT(stakind5) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.staop1    ACL     I   GRANT SELECT(staop1) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.staop2    ACL     I   GRANT SELECT(staop2) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.staop3    ACL     I   GRANT SELECT(staop3) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.staop4    ACL     I   GRANT SELECT(staop4) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.staop5    ACL     I   GRANT SELECT(staop5) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stacoll1    ACL     K   GRANT SELECT(stacoll1) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stacoll2    ACL     K   GRANT SELECT(stacoll2) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stacoll3    ACL     K   GRANT SELECT(stacoll3) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stacoll4    ACL     K   GRANT SELECT(stacoll4) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stacoll5    ACL     K   GRANT SELECT(stacoll5) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stanumbers1    ACL     N   GRANT SELECT(stanumbers1) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stanumbers2    ACL     N   GRANT SELECT(stanumbers2) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stanumbers3    ACL     N   GRANT SELECT(stanumbers3) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stanumbers4    ACL     N   GRANT SELECT(stanumbers4) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stanumbers5    ACL     N   GRANT SELECT(stanumbers5) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stavalues1    ACL     M   GRANT SELECT(stavalues1) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stavalues2    ACL     M   GRANT SELECT(stavalues2) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stavalues3    ACL     M   GRANT SELECT(stavalues3) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stavalues4    ACL     M   GRANT SELECT(stavalues4) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_statistic.stavalues5    ACL     M   GRANT SELECT(stavalues5) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            �           0    0    COLUMN pg_subscription.oid    ACL     I   GRANT SELECT(oid) ON TABLE pg_catalog.pg_subscription TO azure_pg_admin;
       
   pg_catalog               azuresu    false    64            �           0    0    COLUMN pg_subscription.subdbid    ACL     M   GRANT SELECT(subdbid) ON TABLE pg_catalog.pg_subscription TO azure_pg_admin;
       
   pg_catalog               azuresu    false    64            �           0    0    COLUMN pg_subscription.subname    ACL     M   GRANT SELECT(subname) ON TABLE pg_catalog.pg_subscription TO azure_pg_admin;
       
   pg_catalog               azuresu    false    64            �           0    0    COLUMN pg_subscription.subowner    ACL     N   GRANT SELECT(subowner) ON TABLE pg_catalog.pg_subscription TO azure_pg_admin;
       
   pg_catalog               azuresu    false    64            �           0    0 !   COLUMN pg_subscription.subenabled    ACL     P   GRANT SELECT(subenabled) ON TABLE pg_catalog.pg_subscription TO azure_pg_admin;
       
   pg_catalog               azuresu    false    64            �           0    0 "   COLUMN pg_subscription.subconninfo    ACL     Q   GRANT SELECT(subconninfo) ON TABLE pg_catalog.pg_subscription TO azure_pg_admin;
       
   pg_catalog               azuresu    false    64            �           0    0 "   COLUMN pg_subscription.subslotname    ACL     Q   GRANT SELECT(subslotname) ON TABLE pg_catalog.pg_subscription TO azure_pg_admin;
       
   pg_catalog               azuresu    false    64            �           0    0 $   COLUMN pg_subscription.subsynccommit    ACL     S   GRANT SELECT(subsynccommit) ON TABLE pg_catalog.pg_subscription TO azure_pg_admin;
       
   pg_catalog               azuresu    false    64            �           0    0 &   COLUMN pg_subscription.subpublications    ACL     U   GRANT SELECT(subpublications) ON TABLE pg_catalog.pg_subscription TO azure_pg_admin;
       
   pg_catalog               azuresu    false    64            �            1259    24822    admin_event_entity    TABLE     �  CREATE TABLE public.admin_event_entity (
    id character varying(36) NOT NULL,
    admin_event_time bigint,
    realm_id character varying(255),
    operation_type character varying(255),
    auth_realm_id character varying(255),
    auth_client_id character varying(255),
    auth_user_id character varying(255),
    ip_address character varying(255),
    resource_path character varying(2550),
    representation text,
    error character varying(255),
    resource_type character varying(64)
);
 &   DROP TABLE public.admin_event_entity;
       public         heap r    	   adminmweb    false    5            �            1259    24827    associated_policy    TABLE     �   CREATE TABLE public.associated_policy (
    policy_id character varying(36) NOT NULL,
    associated_policy_id character varying(36) NOT NULL
);
 %   DROP TABLE public.associated_policy;
       public         heap r    	   adminmweb    false    5            �            1259    24830    authentication_execution    TABLE     �  CREATE TABLE public.authentication_execution (
    id character varying(36) NOT NULL,
    alias character varying(255),
    authenticator character varying(36),
    realm_id character varying(36),
    flow_id character varying(36),
    requirement integer,
    priority integer,
    authenticator_flow boolean DEFAULT false NOT NULL,
    auth_flow_id character varying(36),
    auth_config character varying(36)
);
 ,   DROP TABLE public.authentication_execution;
       public         heap r    	   adminmweb    false    5            �            1259    24834    authentication_flow    TABLE     t  CREATE TABLE public.authentication_flow (
    id character varying(36) NOT NULL,
    alias character varying(255),
    description character varying(255),
    realm_id character varying(36),
    provider_id character varying(36) DEFAULT 'basic-flow'::character varying NOT NULL,
    top_level boolean DEFAULT false NOT NULL,
    built_in boolean DEFAULT false NOT NULL
);
 '   DROP TABLE public.authentication_flow;
       public         heap r    	   adminmweb    false    5            �            1259    24842    authenticator_config    TABLE     �   CREATE TABLE public.authenticator_config (
    id character varying(36) NOT NULL,
    alias character varying(255),
    realm_id character varying(36)
);
 (   DROP TABLE public.authenticator_config;
       public         heap r    	   adminmweb    false    5            �            1259    24845    authenticator_config_entry    TABLE     �   CREATE TABLE public.authenticator_config_entry (
    authenticator_id character varying(36) NOT NULL,
    value text,
    name character varying(255) NOT NULL
);
 .   DROP TABLE public.authenticator_config_entry;
       public         heap r    	   adminmweb    false    5            �            1259    24850    broker_link    TABLE     L  CREATE TABLE public.broker_link (
    identity_provider character varying(255) NOT NULL,
    storage_provider_id character varying(255),
    realm_id character varying(36) NOT NULL,
    broker_user_id character varying(255),
    broker_username character varying(255),
    token text,
    user_id character varying(255) NOT NULL
);
    DROP TABLE public.broker_link;
       public         heap r    	   adminmweb    false    5            �            1259    24855    client    TABLE     �  CREATE TABLE public.client (
    id character varying(36) NOT NULL,
    enabled boolean DEFAULT false NOT NULL,
    full_scope_allowed boolean DEFAULT false NOT NULL,
    client_id character varying(255),
    not_before integer,
    public_client boolean DEFAULT false NOT NULL,
    secret character varying(255),
    base_url character varying(255),
    bearer_only boolean DEFAULT false NOT NULL,
    management_url character varying(255),
    surrogate_auth_required boolean DEFAULT false NOT NULL,
    realm_id character varying(36),
    protocol character varying(255),
    node_rereg_timeout integer DEFAULT 0,
    frontchannel_logout boolean DEFAULT false NOT NULL,
    consent_required boolean DEFAULT false NOT NULL,
    name character varying(255),
    service_accounts_enabled boolean DEFAULT false NOT NULL,
    client_authenticator_type character varying(255),
    root_url character varying(255),
    description character varying(255),
    registration_token character varying(255),
    standard_flow_enabled boolean DEFAULT true NOT NULL,
    implicit_flow_enabled boolean DEFAULT false NOT NULL,
    direct_access_grants_enabled boolean DEFAULT false NOT NULL,
    always_display_in_console boolean DEFAULT false NOT NULL
);
    DROP TABLE public.client;
       public         heap r    	   adminmweb    false    5            �            1259    24873    client_attributes    TABLE     �   CREATE TABLE public.client_attributes (
    client_id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    value text
);
 %   DROP TABLE public.client_attributes;
       public         heap r    	   adminmweb    false    5            �            1259    24878    client_auth_flow_bindings    TABLE     �   CREATE TABLE public.client_auth_flow_bindings (
    client_id character varying(36) NOT NULL,
    flow_id character varying(36),
    binding_name character varying(255) NOT NULL
);
 -   DROP TABLE public.client_auth_flow_bindings;
       public         heap r    	   adminmweb    false    5            �            1259    24881    client_initial_access    TABLE     �   CREATE TABLE public.client_initial_access (
    id character varying(36) NOT NULL,
    realm_id character varying(36) NOT NULL,
    "timestamp" integer,
    expiration integer,
    count integer,
    remaining_count integer
);
 )   DROP TABLE public.client_initial_access;
       public         heap r    	   adminmweb    false    5            �            1259    24884    client_node_registrations    TABLE     �   CREATE TABLE public.client_node_registrations (
    client_id character varying(36) NOT NULL,
    value integer,
    name character varying(255) NOT NULL
);
 -   DROP TABLE public.client_node_registrations;
       public         heap r    	   adminmweb    false    5            �            1259    24887    client_scope    TABLE     �   CREATE TABLE public.client_scope (
    id character varying(36) NOT NULL,
    name character varying(255),
    realm_id character varying(36),
    description character varying(255),
    protocol character varying(255)
);
     DROP TABLE public.client_scope;
       public         heap r    	   adminmweb    false    5            �            1259    24892    client_scope_attributes    TABLE     �   CREATE TABLE public.client_scope_attributes (
    scope_id character varying(36) NOT NULL,
    value character varying(2048),
    name character varying(255) NOT NULL
);
 +   DROP TABLE public.client_scope_attributes;
       public         heap r    	   adminmweb    false    5            �            1259    24897    client_scope_client    TABLE     �   CREATE TABLE public.client_scope_client (
    client_id character varying(255) NOT NULL,
    scope_id character varying(255) NOT NULL,
    default_scope boolean DEFAULT false NOT NULL
);
 '   DROP TABLE public.client_scope_client;
       public         heap r    	   adminmweb    false    5            �            1259    24903    client_scope_role_mapping    TABLE     �   CREATE TABLE public.client_scope_role_mapping (
    scope_id character varying(36) NOT NULL,
    role_id character varying(36) NOT NULL
);
 -   DROP TABLE public.client_scope_role_mapping;
       public         heap r    	   adminmweb    false    5            �            1259    24906    client_session    TABLE     �  CREATE TABLE public.client_session (
    id character varying(36) NOT NULL,
    client_id character varying(36),
    redirect_uri character varying(255),
    state character varying(255),
    "timestamp" integer,
    session_id character varying(36),
    auth_method character varying(255),
    realm_id character varying(255),
    auth_user_id character varying(36),
    current_action character varying(36)
);
 "   DROP TABLE public.client_session;
       public         heap r    	   adminmweb    false    5            �            1259    24911    client_session_auth_status    TABLE     �   CREATE TABLE public.client_session_auth_status (
    authenticator character varying(36) NOT NULL,
    status integer,
    client_session character varying(36) NOT NULL
);
 .   DROP TABLE public.client_session_auth_status;
       public         heap r    	   adminmweb    false    5            �            1259    24914    client_session_note    TABLE     �   CREATE TABLE public.client_session_note (
    name character varying(255) NOT NULL,
    value character varying(255),
    client_session character varying(36) NOT NULL
);
 '   DROP TABLE public.client_session_note;
       public         heap r    	   adminmweb    false    5            �            1259    24919    client_session_prot_mapper    TABLE     �   CREATE TABLE public.client_session_prot_mapper (
    protocol_mapper_id character varying(36) NOT NULL,
    client_session character varying(36) NOT NULL
);
 .   DROP TABLE public.client_session_prot_mapper;
       public         heap r    	   adminmweb    false    5            �            1259    24922    client_session_role    TABLE     �   CREATE TABLE public.client_session_role (
    role_id character varying(255) NOT NULL,
    client_session character varying(36) NOT NULL
);
 '   DROP TABLE public.client_session_role;
       public         heap r    	   adminmweb    false    5            �            1259    24925    client_user_session_note    TABLE     �   CREATE TABLE public.client_user_session_note (
    name character varying(255) NOT NULL,
    value character varying(2048),
    client_session character varying(36) NOT NULL
);
 ,   DROP TABLE public.client_user_session_note;
       public         heap r    	   adminmweb    false    5            �            1259    24930 	   component    TABLE     )  CREATE TABLE public.component (
    id character varying(36) NOT NULL,
    name character varying(255),
    parent_id character varying(36),
    provider_id character varying(36),
    provider_type character varying(255),
    realm_id character varying(36),
    sub_type character varying(255)
);
    DROP TABLE public.component;
       public         heap r    	   adminmweb    false    5            �            1259    24935    component_config    TABLE     �   CREATE TABLE public.component_config (
    id character varying(36) NOT NULL,
    component_id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    value text
);
 $   DROP TABLE public.component_config;
       public         heap r    	   adminmweb    false    5            �            1259    24940    composite_role    TABLE     �   CREATE TABLE public.composite_role (
    composite character varying(36) NOT NULL,
    child_role character varying(36) NOT NULL
);
 "   DROP TABLE public.composite_role;
       public         heap r    	   adminmweb    false    5            �            1259    24943 
   credential    TABLE     $  CREATE TABLE public.credential (
    id character varying(36) NOT NULL,
    salt bytea,
    type character varying(255),
    user_id character varying(36),
    created_date bigint,
    user_label character varying(255),
    secret_data text,
    credential_data text,
    priority integer
);
    DROP TABLE public.credential;
       public         heap r    	   adminmweb    false    5            �            1259    24948    databasechangelog    TABLE     Y  CREATE TABLE public.databasechangelog (
    id character varying(255) NOT NULL,
    author character varying(255) NOT NULL,
    filename character varying(255) NOT NULL,
    dateexecuted timestamp without time zone NOT NULL,
    orderexecuted integer NOT NULL,
    exectype character varying(10) NOT NULL,
    md5sum character varying(35),
    description character varying(255),
    comments character varying(255),
    tag character varying(255),
    liquibase character varying(20),
    contexts character varying(255),
    labels character varying(255),
    deployment_id character varying(10)
);
 %   DROP TABLE public.databasechangelog;
       public         heap r    	   adminmweb    false    5            �            1259    24953    databasechangeloglock    TABLE     �   CREATE TABLE public.databasechangeloglock (
    id integer NOT NULL,
    locked boolean NOT NULL,
    lockgranted timestamp without time zone,
    lockedby character varying(255)
);
 )   DROP TABLE public.databasechangeloglock;
       public         heap r    	   adminmweb    false    5            �            1259    24956    default_client_scope    TABLE     �   CREATE TABLE public.default_client_scope (
    realm_id character varying(36) NOT NULL,
    scope_id character varying(36) NOT NULL,
    default_scope boolean DEFAULT false NOT NULL
);
 (   DROP TABLE public.default_client_scope;
       public         heap r    	   adminmweb    false    5            �            1259    24960    event_entity    TABLE     �  CREATE TABLE public.event_entity (
    id character varying(36) NOT NULL,
    client_id character varying(255),
    details_json character varying(2550),
    error character varying(255),
    ip_address character varying(255),
    realm_id character varying(255),
    session_id character varying(255),
    event_time bigint,
    type character varying(255),
    user_id character varying(255),
    details_json_long_value text
);
     DROP TABLE public.event_entity;
       public         heap r    	   adminmweb    false    5            �            1259    24965    fed_user_attribute    TABLE     (  CREATE TABLE public.fed_user_attribute (
    id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    user_id character varying(255) NOT NULL,
    realm_id character varying(36) NOT NULL,
    storage_provider_id character varying(36),
    value character varying(2024)
);
 &   DROP TABLE public.fed_user_attribute;
       public         heap r    	   adminmweb    false    5            �            1259    24970    fed_user_consent    TABLE     �  CREATE TABLE public.fed_user_consent (
    id character varying(36) NOT NULL,
    client_id character varying(255),
    user_id character varying(255) NOT NULL,
    realm_id character varying(36) NOT NULL,
    storage_provider_id character varying(36),
    created_date bigint,
    last_updated_date bigint,
    client_storage_provider character varying(36),
    external_client_id character varying(255)
);
 $   DROP TABLE public.fed_user_consent;
       public         heap r    	   adminmweb    false    5            �            1259    24975    fed_user_consent_cl_scope    TABLE     �   CREATE TABLE public.fed_user_consent_cl_scope (
    user_consent_id character varying(36) NOT NULL,
    scope_id character varying(36) NOT NULL
);
 -   DROP TABLE public.fed_user_consent_cl_scope;
       public         heap r    	   adminmweb    false    5            �            1259    24978    fed_user_credential    TABLE     �  CREATE TABLE public.fed_user_credential (
    id character varying(36) NOT NULL,
    salt bytea,
    type character varying(255),
    created_date bigint,
    user_id character varying(255) NOT NULL,
    realm_id character varying(36) NOT NULL,
    storage_provider_id character varying(36),
    user_label character varying(255),
    secret_data text,
    credential_data text,
    priority integer
);
 '   DROP TABLE public.fed_user_credential;
       public         heap r    	   adminmweb    false    5            �            1259    24983    fed_user_group_membership    TABLE     �   CREATE TABLE public.fed_user_group_membership (
    group_id character varying(36) NOT NULL,
    user_id character varying(255) NOT NULL,
    realm_id character varying(36) NOT NULL,
    storage_provider_id character varying(36)
);
 -   DROP TABLE public.fed_user_group_membership;
       public         heap r    	   adminmweb    false    5            �            1259    24986    fed_user_required_action    TABLE       CREATE TABLE public.fed_user_required_action (
    required_action character varying(255) DEFAULT ' '::character varying NOT NULL,
    user_id character varying(255) NOT NULL,
    realm_id character varying(36) NOT NULL,
    storage_provider_id character varying(36)
);
 ,   DROP TABLE public.fed_user_required_action;
       public         heap r    	   adminmweb    false    5            �            1259    24992    fed_user_role_mapping    TABLE     �   CREATE TABLE public.fed_user_role_mapping (
    role_id character varying(36) NOT NULL,
    user_id character varying(255) NOT NULL,
    realm_id character varying(36) NOT NULL,
    storage_provider_id character varying(36)
);
 )   DROP TABLE public.fed_user_role_mapping;
       public         heap r    	   adminmweb    false    5            �            1259    24995    federated_identity    TABLE       CREATE TABLE public.federated_identity (
    identity_provider character varying(255) NOT NULL,
    realm_id character varying(36),
    federated_user_id character varying(255),
    federated_username character varying(255),
    token text,
    user_id character varying(36) NOT NULL
);
 &   DROP TABLE public.federated_identity;
       public         heap r    	   adminmweb    false    5            �            1259    25000    federated_user    TABLE     �   CREATE TABLE public.federated_user (
    id character varying(255) NOT NULL,
    storage_provider_id character varying(255),
    realm_id character varying(36) NOT NULL
);
 "   DROP TABLE public.federated_user;
       public         heap r    	   adminmweb    false    5            �            1259    25005    group_attribute    TABLE       CREATE TABLE public.group_attribute (
    id character varying(36) DEFAULT 'sybase-needs-something-here'::character varying NOT NULL,
    name character varying(255) NOT NULL,
    value character varying(255),
    group_id character varying(36) NOT NULL
);
 #   DROP TABLE public.group_attribute;
       public         heap r    	   adminmweb    false    5            �            1259    25011    group_role_mapping    TABLE     �   CREATE TABLE public.group_role_mapping (
    role_id character varying(36) NOT NULL,
    group_id character varying(36) NOT NULL
);
 &   DROP TABLE public.group_role_mapping;
       public         heap r    	   adminmweb    false    5                        1259    25014    identity_provider    TABLE     �  CREATE TABLE public.identity_provider (
    internal_id character varying(36) NOT NULL,
    enabled boolean DEFAULT false NOT NULL,
    provider_alias character varying(255),
    provider_id character varying(255),
    store_token boolean DEFAULT false NOT NULL,
    authenticate_by_default boolean DEFAULT false NOT NULL,
    realm_id character varying(36),
    add_token_role boolean DEFAULT true NOT NULL,
    trust_email boolean DEFAULT false NOT NULL,
    first_broker_login_flow_id character varying(36),
    post_broker_login_flow_id character varying(36),
    provider_display_name character varying(255),
    link_only boolean DEFAULT false NOT NULL
);
 %   DROP TABLE public.identity_provider;
       public         heap r    	   adminmweb    false    5                       1259    25025    identity_provider_config    TABLE     �   CREATE TABLE public.identity_provider_config (
    identity_provider_id character varying(36) NOT NULL,
    value text,
    name character varying(255) NOT NULL
);
 ,   DROP TABLE public.identity_provider_config;
       public         heap r    	   adminmweb    false    5                       1259    25030    identity_provider_mapper    TABLE       CREATE TABLE public.identity_provider_mapper (
    id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    idp_alias character varying(255) NOT NULL,
    idp_mapper_name character varying(255) NOT NULL,
    realm_id character varying(36) NOT NULL
);
 ,   DROP TABLE public.identity_provider_mapper;
       public         heap r    	   adminmweb    false    5                       1259    25035    idp_mapper_config    TABLE     �   CREATE TABLE public.idp_mapper_config (
    idp_mapper_id character varying(36) NOT NULL,
    value text,
    name character varying(255) NOT NULL
);
 %   DROP TABLE public.idp_mapper_config;
       public         heap r    	   adminmweb    false    5                       1259    25040    keycloak_group    TABLE     �   CREATE TABLE public.keycloak_group (
    id character varying(36) NOT NULL,
    name character varying(255),
    parent_group character varying(36) NOT NULL,
    realm_id character varying(36)
);
 "   DROP TABLE public.keycloak_group;
       public         heap r    	   adminmweb    false    5                       1259    25043    keycloak_role    TABLE     b  CREATE TABLE public.keycloak_role (
    id character varying(36) NOT NULL,
    client_realm_constraint character varying(255),
    client_role boolean DEFAULT false NOT NULL,
    description character varying(255),
    name character varying(255),
    realm_id character varying(255),
    client character varying(36),
    realm character varying(36)
);
 !   DROP TABLE public.keycloak_role;
       public         heap r    	   adminmweb    false    5                       1259    25049    migration_model    TABLE     �   CREATE TABLE public.migration_model (
    id character varying(36) NOT NULL,
    version character varying(36),
    update_time bigint DEFAULT 0 NOT NULL
);
 #   DROP TABLE public.migration_model;
       public         heap r    	   adminmweb    false    5                       1259    25053    offline_client_session    TABLE     �  CREATE TABLE public.offline_client_session (
    user_session_id character varying(36) NOT NULL,
    client_id character varying(255) NOT NULL,
    offline_flag character varying(4) NOT NULL,
    "timestamp" integer,
    data text,
    client_storage_provider character varying(36) DEFAULT 'local'::character varying NOT NULL,
    external_client_id character varying(255) DEFAULT 'local'::character varying NOT NULL
);
 *   DROP TABLE public.offline_client_session;
       public         heap r    	   adminmweb    false    5                       1259    25060    offline_user_session    TABLE     P  CREATE TABLE public.offline_user_session (
    user_session_id character varying(36) NOT NULL,
    user_id character varying(255) NOT NULL,
    realm_id character varying(36) NOT NULL,
    created_on integer NOT NULL,
    offline_flag character varying(4) NOT NULL,
    data text,
    last_session_refresh integer DEFAULT 0 NOT NULL
);
 (   DROP TABLE public.offline_user_session;
       public         heap r    	   adminmweb    false    5            	           1259    25066    policy_config    TABLE     �   CREATE TABLE public.policy_config (
    policy_id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    value text
);
 !   DROP TABLE public.policy_config;
       public         heap r    	   adminmweb    false    5            
           1259    25071    protocol_mapper    TABLE     1  CREATE TABLE public.protocol_mapper (
    id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    protocol character varying(255) NOT NULL,
    protocol_mapper_name character varying(255) NOT NULL,
    client_id character varying(36),
    client_scope_id character varying(36)
);
 #   DROP TABLE public.protocol_mapper;
       public         heap r    	   adminmweb    false    5                       1259    25076    protocol_mapper_config    TABLE     �   CREATE TABLE public.protocol_mapper_config (
    protocol_mapper_id character varying(36) NOT NULL,
    value text,
    name character varying(255) NOT NULL
);
 *   DROP TABLE public.protocol_mapper_config;
       public         heap r    	   adminmweb    false    5                       1259    25081    realm    TABLE     �	  CREATE TABLE public.realm (
    id character varying(36) NOT NULL,
    access_code_lifespan integer,
    user_action_lifespan integer,
    access_token_lifespan integer,
    account_theme character varying(255),
    admin_theme character varying(255),
    email_theme character varying(255),
    enabled boolean DEFAULT false NOT NULL,
    events_enabled boolean DEFAULT false NOT NULL,
    events_expiration bigint,
    login_theme character varying(255),
    name character varying(255),
    not_before integer,
    password_policy character varying(2550),
    registration_allowed boolean DEFAULT false NOT NULL,
    remember_me boolean DEFAULT false NOT NULL,
    reset_password_allowed boolean DEFAULT false NOT NULL,
    social boolean DEFAULT false NOT NULL,
    ssl_required character varying(255),
    sso_idle_timeout integer,
    sso_max_lifespan integer,
    update_profile_on_soc_login boolean DEFAULT false NOT NULL,
    verify_email boolean DEFAULT false NOT NULL,
    master_admin_client character varying(36),
    login_lifespan integer,
    internationalization_enabled boolean DEFAULT false NOT NULL,
    default_locale character varying(255),
    reg_email_as_username boolean DEFAULT false NOT NULL,
    admin_events_enabled boolean DEFAULT false NOT NULL,
    admin_events_details_enabled boolean DEFAULT false NOT NULL,
    edit_username_allowed boolean DEFAULT false NOT NULL,
    otp_policy_counter integer DEFAULT 0,
    otp_policy_window integer DEFAULT 1,
    otp_policy_period integer DEFAULT 30,
    otp_policy_digits integer DEFAULT 6,
    otp_policy_alg character varying(36) DEFAULT 'HmacSHA1'::character varying,
    otp_policy_type character varying(36) DEFAULT 'totp'::character varying,
    browser_flow character varying(36),
    registration_flow character varying(36),
    direct_grant_flow character varying(36),
    reset_credentials_flow character varying(36),
    client_auth_flow character varying(36),
    offline_session_idle_timeout integer DEFAULT 0,
    revoke_refresh_token boolean DEFAULT false NOT NULL,
    access_token_life_implicit integer DEFAULT 0,
    login_with_email_allowed boolean DEFAULT true NOT NULL,
    duplicate_emails_allowed boolean DEFAULT false NOT NULL,
    docker_auth_flow character varying(36),
    refresh_token_max_reuse integer DEFAULT 0,
    allow_user_managed_access boolean DEFAULT false NOT NULL,
    sso_max_lifespan_remember_me integer DEFAULT 0 NOT NULL,
    sso_idle_timeout_remember_me integer DEFAULT 0 NOT NULL,
    default_role character varying(255)
);
    DROP TABLE public.realm;
       public         heap r    	   adminmweb    false    5                       1259    25114    realm_attribute    TABLE     �   CREATE TABLE public.realm_attribute (
    name character varying(255) NOT NULL,
    realm_id character varying(36) NOT NULL,
    value text
);
 #   DROP TABLE public.realm_attribute;
       public         heap r    	   adminmweb    false    5                       1259    25119    realm_default_groups    TABLE     �   CREATE TABLE public.realm_default_groups (
    realm_id character varying(36) NOT NULL,
    group_id character varying(36) NOT NULL
);
 (   DROP TABLE public.realm_default_groups;
       public         heap r    	   adminmweb    false    5                       1259    25122    realm_enabled_event_types    TABLE     �   CREATE TABLE public.realm_enabled_event_types (
    realm_id character varying(36) NOT NULL,
    value character varying(255) NOT NULL
);
 -   DROP TABLE public.realm_enabled_event_types;
       public         heap r    	   adminmweb    false    5                       1259    25125    realm_events_listeners    TABLE     �   CREATE TABLE public.realm_events_listeners (
    realm_id character varying(36) NOT NULL,
    value character varying(255) NOT NULL
);
 *   DROP TABLE public.realm_events_listeners;
       public         heap r    	   adminmweb    false    5                       1259    25128    realm_localizations    TABLE     �   CREATE TABLE public.realm_localizations (
    realm_id character varying(255) NOT NULL,
    locale character varying(255) NOT NULL,
    texts text NOT NULL
);
 '   DROP TABLE public.realm_localizations;
       public         heap r    	   adminmweb    false    5                       1259    25133    realm_required_credential    TABLE       CREATE TABLE public.realm_required_credential (
    type character varying(255) NOT NULL,
    form_label character varying(255),
    input boolean DEFAULT false NOT NULL,
    secret boolean DEFAULT false NOT NULL,
    realm_id character varying(36) NOT NULL
);
 -   DROP TABLE public.realm_required_credential;
       public         heap r    	   adminmweb    false    5                       1259    25140    realm_smtp_config    TABLE     �   CREATE TABLE public.realm_smtp_config (
    realm_id character varying(36) NOT NULL,
    value character varying(255),
    name character varying(255) NOT NULL
);
 %   DROP TABLE public.realm_smtp_config;
       public         heap r    	   adminmweb    false    5                       1259    25145    realm_supported_locales    TABLE     �   CREATE TABLE public.realm_supported_locales (
    realm_id character varying(36) NOT NULL,
    value character varying(255) NOT NULL
);
 +   DROP TABLE public.realm_supported_locales;
       public         heap r    	   adminmweb    false    5                       1259    25148    redirect_uris    TABLE        CREATE TABLE public.redirect_uris (
    client_id character varying(36) NOT NULL,
    value character varying(255) NOT NULL
);
 !   DROP TABLE public.redirect_uris;
       public         heap r    	   adminmweb    false    5                       1259    25151    required_action_config    TABLE     �   CREATE TABLE public.required_action_config (
    required_action_id character varying(36) NOT NULL,
    value text,
    name character varying(255) NOT NULL
);
 *   DROP TABLE public.required_action_config;
       public         heap r    	   adminmweb    false    5                       1259    25156    required_action_provider    TABLE     \  CREATE TABLE public.required_action_provider (
    id character varying(36) NOT NULL,
    alias character varying(255),
    name character varying(255),
    realm_id character varying(36),
    enabled boolean DEFAULT false NOT NULL,
    default_action boolean DEFAULT false NOT NULL,
    provider_id character varying(255),
    priority integer
);
 ,   DROP TABLE public.required_action_provider;
       public         heap r    	   adminmweb    false    5                       1259    25163    resource_attribute    TABLE       CREATE TABLE public.resource_attribute (
    id character varying(36) DEFAULT 'sybase-needs-something-here'::character varying NOT NULL,
    name character varying(255) NOT NULL,
    value character varying(255),
    resource_id character varying(36) NOT NULL
);
 &   DROP TABLE public.resource_attribute;
       public         heap r    	   adminmweb    false    5                       1259    25169    resource_policy    TABLE     �   CREATE TABLE public.resource_policy (
    resource_id character varying(36) NOT NULL,
    policy_id character varying(36) NOT NULL
);
 #   DROP TABLE public.resource_policy;
       public         heap r    	   adminmweb    false    5                       1259    25172    resource_scope    TABLE     �   CREATE TABLE public.resource_scope (
    resource_id character varying(36) NOT NULL,
    scope_id character varying(36) NOT NULL
);
 "   DROP TABLE public.resource_scope;
       public         heap r    	   adminmweb    false    5                       1259    25175    resource_server    TABLE     �   CREATE TABLE public.resource_server (
    id character varying(36) NOT NULL,
    allow_rs_remote_mgmt boolean DEFAULT false NOT NULL,
    policy_enforce_mode smallint NOT NULL,
    decision_strategy smallint DEFAULT 1 NOT NULL
);
 #   DROP TABLE public.resource_server;
       public         heap r    	   adminmweb    false    5                       1259    25180    resource_server_perm_ticket    TABLE     �  CREATE TABLE public.resource_server_perm_ticket (
    id character varying(36) NOT NULL,
    owner character varying(255) NOT NULL,
    requester character varying(255) NOT NULL,
    created_timestamp bigint NOT NULL,
    granted_timestamp bigint,
    resource_id character varying(36) NOT NULL,
    scope_id character varying(36),
    resource_server_id character varying(36) NOT NULL,
    policy_id character varying(36)
);
 /   DROP TABLE public.resource_server_perm_ticket;
       public         heap r    	   adminmweb    false    5                       1259    25185    resource_server_policy    TABLE     _  CREATE TABLE public.resource_server_policy (
    id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    description character varying(255),
    type character varying(255) NOT NULL,
    decision_strategy smallint,
    logic smallint,
    resource_server_id character varying(36) NOT NULL,
    owner character varying(255)
);
 *   DROP TABLE public.resource_server_policy;
       public         heap r    	   adminmweb    false    5                       1259    25190    resource_server_resource    TABLE     �  CREATE TABLE public.resource_server_resource (
    id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    type character varying(255),
    icon_uri character varying(255),
    owner character varying(255) NOT NULL,
    resource_server_id character varying(36) NOT NULL,
    owner_managed_access boolean DEFAULT false NOT NULL,
    display_name character varying(255)
);
 ,   DROP TABLE public.resource_server_resource;
       public         heap r    	   adminmweb    false    5                       1259    25196    resource_server_scope    TABLE       CREATE TABLE public.resource_server_scope (
    id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    icon_uri character varying(255),
    resource_server_id character varying(36) NOT NULL,
    display_name character varying(255)
);
 )   DROP TABLE public.resource_server_scope;
       public         heap r    	   adminmweb    false    5                        1259    25201    resource_uris    TABLE     �   CREATE TABLE public.resource_uris (
    resource_id character varying(36) NOT NULL,
    value character varying(255) NOT NULL
);
 !   DROP TABLE public.resource_uris;
       public         heap r    	   adminmweb    false    5            !           1259    25204    role_attribute    TABLE     �   CREATE TABLE public.role_attribute (
    id character varying(36) NOT NULL,
    role_id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    value character varying(255)
);
 "   DROP TABLE public.role_attribute;
       public         heap r    	   adminmweb    false    5            "           1259    25209    scope_mapping    TABLE     �   CREATE TABLE public.scope_mapping (
    client_id character varying(36) NOT NULL,
    role_id character varying(36) NOT NULL
);
 !   DROP TABLE public.scope_mapping;
       public         heap r    	   adminmweb    false    5            #           1259    25212    scope_policy    TABLE     �   CREATE TABLE public.scope_policy (
    scope_id character varying(36) NOT NULL,
    policy_id character varying(36) NOT NULL
);
     DROP TABLE public.scope_policy;
       public         heap r    	   adminmweb    false    5            $           1259    25215    user_attribute    TABLE     �   CREATE TABLE public.user_attribute (
    name character varying(255) NOT NULL,
    value character varying(255),
    user_id character varying(36) NOT NULL,
    id character varying(36) DEFAULT 'sybase-needs-something-here'::character varying NOT NULL
);
 "   DROP TABLE public.user_attribute;
       public         heap r    	   adminmweb    false    5            %           1259    25221    user_consent    TABLE     7  CREATE TABLE public.user_consent (
    id character varying(36) NOT NULL,
    client_id character varying(255),
    user_id character varying(36) NOT NULL,
    created_date bigint,
    last_updated_date bigint,
    client_storage_provider character varying(36),
    external_client_id character varying(255)
);
     DROP TABLE public.user_consent;
       public         heap r    	   adminmweb    false    5            &           1259    25226    user_consent_client_scope    TABLE     �   CREATE TABLE public.user_consent_client_scope (
    user_consent_id character varying(36) NOT NULL,
    scope_id character varying(36) NOT NULL
);
 -   DROP TABLE public.user_consent_client_scope;
       public         heap r    	   adminmweb    false    5            '           1259    25229    user_entity    TABLE     =  CREATE TABLE public.user_entity (
    id character varying(36) NOT NULL,
    email character varying(255),
    email_constraint character varying(255),
    email_verified boolean DEFAULT false NOT NULL,
    enabled boolean DEFAULT false NOT NULL,
    federation_link character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    realm_id character varying(255),
    username character varying(255),
    created_timestamp bigint,
    service_account_client_link character varying(255),
    not_before integer DEFAULT 0 NOT NULL
);
    DROP TABLE public.user_entity;
       public         heap r    	   adminmweb    false    5            (           1259    25237    user_federation_config    TABLE     �   CREATE TABLE public.user_federation_config (
    user_federation_provider_id character varying(36) NOT NULL,
    value character varying(255),
    name character varying(255) NOT NULL
);
 *   DROP TABLE public.user_federation_config;
       public         heap r    	   adminmweb    false    5            )           1259    25242    user_federation_mapper    TABLE     $  CREATE TABLE public.user_federation_mapper (
    id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    federation_provider_id character varying(36) NOT NULL,
    federation_mapper_type character varying(255) NOT NULL,
    realm_id character varying(36) NOT NULL
);
 *   DROP TABLE public.user_federation_mapper;
       public         heap r    	   adminmweb    false    5            *           1259    25247    user_federation_mapper_config    TABLE     �   CREATE TABLE public.user_federation_mapper_config (
    user_federation_mapper_id character varying(36) NOT NULL,
    value character varying(255),
    name character varying(255) NOT NULL
);
 1   DROP TABLE public.user_federation_mapper_config;
       public         heap r    	   adminmweb    false    5            +           1259    25252    user_federation_provider    TABLE     ;  CREATE TABLE public.user_federation_provider (
    id character varying(36) NOT NULL,
    changed_sync_period integer,
    display_name character varying(255),
    full_sync_period integer,
    last_sync integer,
    priority integer,
    provider_name character varying(255),
    realm_id character varying(36)
);
 ,   DROP TABLE public.user_federation_provider;
       public         heap r    	   adminmweb    false    5            ,           1259    25257    user_group_membership    TABLE     �   CREATE TABLE public.user_group_membership (
    group_id character varying(36) NOT NULL,
    user_id character varying(36) NOT NULL
);
 )   DROP TABLE public.user_group_membership;
       public         heap r    	   adminmweb    false    5            -           1259    25260    user_required_action    TABLE     �   CREATE TABLE public.user_required_action (
    user_id character varying(36) NOT NULL,
    required_action character varying(255) DEFAULT ' '::character varying NOT NULL
);
 (   DROP TABLE public.user_required_action;
       public         heap r    	   adminmweb    false    5            .           1259    25264    user_role_mapping    TABLE     �   CREATE TABLE public.user_role_mapping (
    role_id character varying(255) NOT NULL,
    user_id character varying(36) NOT NULL
);
 %   DROP TABLE public.user_role_mapping;
       public         heap r    	   adminmweb    false    5            /           1259    25267    user_session    TABLE     �  CREATE TABLE public.user_session (
    id character varying(36) NOT NULL,
    auth_method character varying(255),
    ip_address character varying(255),
    last_session_refresh integer,
    login_username character varying(255),
    realm_id character varying(255),
    remember_me boolean DEFAULT false NOT NULL,
    started integer,
    user_id character varying(255),
    user_session_state integer,
    broker_session_id character varying(255),
    broker_user_id character varying(255)
);
     DROP TABLE public.user_session;
       public         heap r    	   adminmweb    false    5            0           1259    25273    user_session_note    TABLE     �   CREATE TABLE public.user_session_note (
    user_session character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    value character varying(2048)
);
 %   DROP TABLE public.user_session_note;
       public         heap r    	   adminmweb    false    5            1           1259    25278    username_login_failure    TABLE       CREATE TABLE public.username_login_failure (
    realm_id character varying(36) NOT NULL,
    username character varying(255) NOT NULL,
    failed_login_not_before integer,
    last_failure bigint,
    last_ip_failure character varying(255),
    num_failures integer
);
 *   DROP TABLE public.username_login_failure;
       public         heap r    	   adminmweb    false    5            2           1259    25283    web_origins    TABLE     }   CREATE TABLE public.web_origins (
    client_id character varying(36) NOT NULL,
    value character varying(255) NOT NULL
);
    DROP TABLE public.web_origins;
       public         heap r    	   adminmweb    false    5            �          0    24822    admin_event_entity 
   TABLE DATA           �   COPY public.admin_event_entity (id, admin_event_time, realm_id, operation_type, auth_realm_id, auth_client_id, auth_user_id, ip_address, resource_path, representation, error, resource_type) FROM stdin;
    public            	   adminmweb    false    215   ��      �          0    24827    associated_policy 
   TABLE DATA           L   COPY public.associated_policy (policy_id, associated_policy_id) FROM stdin;
    public            	   adminmweb    false    216   �      �          0    24830    authentication_execution 
   TABLE DATA           �   COPY public.authentication_execution (id, alias, authenticator, realm_id, flow_id, requirement, priority, authenticator_flow, auth_flow_id, auth_config) FROM stdin;
    public            	   adminmweb    false    217   j�      �          0    24834    authentication_flow 
   TABLE DATA           q   COPY public.authentication_flow (id, alias, description, realm_id, provider_id, top_level, built_in) FROM stdin;
    public            	   adminmweb    false    218   �                 0    24842    authenticator_config 
   TABLE DATA           C   COPY public.authenticator_config (id, alias, realm_id) FROM stdin;
    public            	   adminmweb    false    219   ��                0    24845    authenticator_config_entry 
   TABLE DATA           S   COPY public.authenticator_config_entry (authenticator_id, value, name) FROM stdin;
    public            	   adminmweb    false    220   ��                0    24850    broker_link 
   TABLE DATA           �   COPY public.broker_link (identity_provider, storage_provider_id, realm_id, broker_user_id, broker_username, token, user_id) FROM stdin;
    public            	   adminmweb    false    221   O�                0    24855    client 
   TABLE DATA           �  COPY public.client (id, enabled, full_scope_allowed, client_id, not_before, public_client, secret, base_url, bearer_only, management_url, surrogate_auth_required, realm_id, protocol, node_rereg_timeout, frontchannel_logout, consent_required, name, service_accounts_enabled, client_authenticator_type, root_url, description, registration_token, standard_flow_enabled, implicit_flow_enabled, direct_access_grants_enabled, always_display_in_console) FROM stdin;
    public            	   adminmweb    false    222   l�                0    24873    client_attributes 
   TABLE DATA           C   COPY public.client_attributes (client_id, name, value) FROM stdin;
    public            	   adminmweb    false    223   ��                0    24878    client_auth_flow_bindings 
   TABLE DATA           U   COPY public.client_auth_flow_bindings (client_id, flow_id, binding_name) FROM stdin;
    public            	   adminmweb    false    224   ��                0    24881    client_initial_access 
   TABLE DATA           n   COPY public.client_initial_access (id, realm_id, "timestamp", expiration, count, remaining_count) FROM stdin;
    public            	   adminmweb    false    225   ��                0    24884    client_node_registrations 
   TABLE DATA           K   COPY public.client_node_registrations (client_id, value, name) FROM stdin;
    public            	   adminmweb    false    226   ��                0    24887    client_scope 
   TABLE DATA           Q   COPY public.client_scope (id, name, realm_id, description, protocol) FROM stdin;
    public            	   adminmweb    false    227   �      	          0    24892    client_scope_attributes 
   TABLE DATA           H   COPY public.client_scope_attributes (scope_id, value, name) FROM stdin;
    public            	   adminmweb    false    228   v�      
          0    24897    client_scope_client 
   TABLE DATA           Q   COPY public.client_scope_client (client_id, scope_id, default_scope) FROM stdin;
    public            	   adminmweb    false    229   ��                0    24903    client_scope_role_mapping 
   TABLE DATA           F   COPY public.client_scope_role_mapping (scope_id, role_id) FROM stdin;
    public            	   adminmweb    false    230   �                0    24906    client_session 
   TABLE DATA           �   COPY public.client_session (id, client_id, redirect_uri, state, "timestamp", session_id, auth_method, realm_id, auth_user_id, current_action) FROM stdin;
    public            	   adminmweb    false    231   ��                0    24911    client_session_auth_status 
   TABLE DATA           [   COPY public.client_session_auth_status (authenticator, status, client_session) FROM stdin;
    public            	   adminmweb    false    232   ��                0    24914    client_session_note 
   TABLE DATA           J   COPY public.client_session_note (name, value, client_session) FROM stdin;
    public            	   adminmweb    false    233   ��                0    24919    client_session_prot_mapper 
   TABLE DATA           X   COPY public.client_session_prot_mapper (protocol_mapper_id, client_session) FROM stdin;
    public            	   adminmweb    false    234   ��                0    24922    client_session_role 
   TABLE DATA           F   COPY public.client_session_role (role_id, client_session) FROM stdin;
    public            	   adminmweb    false    235   �                0    24925    client_user_session_note 
   TABLE DATA           O   COPY public.client_user_session_note (name, value, client_session) FROM stdin;
    public            	   adminmweb    false    236   0�                0    24930 	   component 
   TABLE DATA           h   COPY public.component (id, name, parent_id, provider_id, provider_type, realm_id, sub_type) FROM stdin;
    public            	   adminmweb    false    237   M�                0    24935    component_config 
   TABLE DATA           I   COPY public.component_config (id, component_id, name, value) FROM stdin;
    public            	   adminmweb    false    238   q�                0    24940    composite_role 
   TABLE DATA           ?   COPY public.composite_role (composite, child_role) FROM stdin;
    public            	   adminmweb    false    239   �'                0    24943 
   credential 
   TABLE DATA              COPY public.credential (id, salt, type, user_id, created_date, user_label, secret_data, credential_data, priority) FROM stdin;
    public            	   adminmweb    false    240   L0                0    24948    databasechangelog 
   TABLE DATA           �   COPY public.databasechangelog (id, author, filename, dateexecuted, orderexecuted, exectype, md5sum, description, comments, tag, liquibase, contexts, labels, deployment_id) FROM stdin;
    public            	   adminmweb    false    241   �2                0    24953    databasechangeloglock 
   TABLE DATA           R   COPY public.databasechangeloglock (id, locked, lockgranted, lockedby) FROM stdin;
    public            	   adminmweb    false    242   PQ                0    24956    default_client_scope 
   TABLE DATA           Q   COPY public.default_client_scope (realm_id, scope_id, default_scope) FROM stdin;
    public            	   adminmweb    false    243   ~Q                0    24960    event_entity 
   TABLE DATA           �   COPY public.event_entity (id, client_id, details_json, error, ip_address, realm_id, session_id, event_time, type, user_id, details_json_long_value) FROM stdin;
    public            	   adminmweb    false    244   �S                0    24965    fed_user_attribute 
   TABLE DATA           e   COPY public.fed_user_attribute (id, name, user_id, realm_id, storage_provider_id, value) FROM stdin;
    public            	   adminmweb    false    245   �S                0    24970    fed_user_consent 
   TABLE DATA           �   COPY public.fed_user_consent (id, client_id, user_id, realm_id, storage_provider_id, created_date, last_updated_date, client_storage_provider, external_client_id) FROM stdin;
    public            	   adminmweb    false    246   �S                0    24975    fed_user_consent_cl_scope 
   TABLE DATA           N   COPY public.fed_user_consent_cl_scope (user_consent_id, scope_id) FROM stdin;
    public            	   adminmweb    false    247   �S                0    24978    fed_user_credential 
   TABLE DATA           �   COPY public.fed_user_credential (id, salt, type, created_date, user_id, realm_id, storage_provider_id, user_label, secret_data, credential_data, priority) FROM stdin;
    public            	   adminmweb    false    248   T                0    24983    fed_user_group_membership 
   TABLE DATA           e   COPY public.fed_user_group_membership (group_id, user_id, realm_id, storage_provider_id) FROM stdin;
    public            	   adminmweb    false    249   +T                0    24986    fed_user_required_action 
   TABLE DATA           k   COPY public.fed_user_required_action (required_action, user_id, realm_id, storage_provider_id) FROM stdin;
    public            	   adminmweb    false    250   HT                 0    24992    fed_user_role_mapping 
   TABLE DATA           `   COPY public.fed_user_role_mapping (role_id, user_id, realm_id, storage_provider_id) FROM stdin;
    public            	   adminmweb    false    251   eT      !          0    24995    federated_identity 
   TABLE DATA           �   COPY public.federated_identity (identity_provider, realm_id, federated_user_id, federated_username, token, user_id) FROM stdin;
    public            	   adminmweb    false    252   �T      "          0    25000    federated_user 
   TABLE DATA           K   COPY public.federated_user (id, storage_provider_id, realm_id) FROM stdin;
    public            	   adminmweb    false    253   �T      #          0    25005    group_attribute 
   TABLE DATA           D   COPY public.group_attribute (id, name, value, group_id) FROM stdin;
    public            	   adminmweb    false    254   �T      $          0    25011    group_role_mapping 
   TABLE DATA           ?   COPY public.group_role_mapping (role_id, group_id) FROM stdin;
    public            	   adminmweb    false    255   �T      %          0    25014    identity_provider 
   TABLE DATA             COPY public.identity_provider (internal_id, enabled, provider_alias, provider_id, store_token, authenticate_by_default, realm_id, add_token_role, trust_email, first_broker_login_flow_id, post_broker_login_flow_id, provider_display_name, link_only) FROM stdin;
    public            	   adminmweb    false    256   �T      &          0    25025    identity_provider_config 
   TABLE DATA           U   COPY public.identity_provider_config (identity_provider_id, value, name) FROM stdin;
    public            	   adminmweb    false    257   U      '          0    25030    identity_provider_mapper 
   TABLE DATA           b   COPY public.identity_provider_mapper (id, name, idp_alias, idp_mapper_name, realm_id) FROM stdin;
    public            	   adminmweb    false    258   0U      (          0    25035    idp_mapper_config 
   TABLE DATA           G   COPY public.idp_mapper_config (idp_mapper_id, value, name) FROM stdin;
    public            	   adminmweb    false    259   MU      )          0    25040    keycloak_group 
   TABLE DATA           J   COPY public.keycloak_group (id, name, parent_group, realm_id) FROM stdin;
    public            	   adminmweb    false    260   jU      *          0    25043    keycloak_role 
   TABLE DATA           }   COPY public.keycloak_role (id, client_realm_constraint, client_role, description, name, realm_id, client, realm) FROM stdin;
    public            	   adminmweb    false    261   �U      +          0    25049    migration_model 
   TABLE DATA           C   COPY public.migration_model (id, version, update_time) FROM stdin;
    public            	   adminmweb    false    262   �a      ,          0    25053    offline_client_session 
   TABLE DATA           �   COPY public.offline_client_session (user_session_id, client_id, offline_flag, "timestamp", data, client_storage_provider, external_client_id) FROM stdin;
    public            	   adminmweb    false    263   �a      -          0    25060    offline_user_session 
   TABLE DATA           �   COPY public.offline_user_session (user_session_id, user_id, realm_id, created_on, offline_flag, data, last_session_refresh) FROM stdin;
    public            	   adminmweb    false    264   �a      .          0    25066    policy_config 
   TABLE DATA           ?   COPY public.policy_config (policy_id, name, value) FROM stdin;
    public            	   adminmweb    false    265   b      /          0    25071    protocol_mapper 
   TABLE DATA           o   COPY public.protocol_mapper (id, name, protocol, protocol_mapper_name, client_id, client_scope_id) FROM stdin;
    public            	   adminmweb    false    266   �b      0          0    25076    protocol_mapper_config 
   TABLE DATA           Q   COPY public.protocol_mapper_config (protocol_mapper_id, value, name) FROM stdin;
    public            	   adminmweb    false    267   {l      1          0    25081    realm 
   TABLE DATA              COPY public.realm (id, access_code_lifespan, user_action_lifespan, access_token_lifespan, account_theme, admin_theme, email_theme, enabled, events_enabled, events_expiration, login_theme, name, not_before, password_policy, registration_allowed, remember_me, reset_password_allowed, social, ssl_required, sso_idle_timeout, sso_max_lifespan, update_profile_on_soc_login, verify_email, master_admin_client, login_lifespan, internationalization_enabled, default_locale, reg_email_as_username, admin_events_enabled, admin_events_details_enabled, edit_username_allowed, otp_policy_counter, otp_policy_window, otp_policy_period, otp_policy_digits, otp_policy_alg, otp_policy_type, browser_flow, registration_flow, direct_grant_flow, reset_credentials_flow, client_auth_flow, offline_session_idle_timeout, revoke_refresh_token, access_token_life_implicit, login_with_email_allowed, duplicate_emails_allowed, docker_auth_flow, refresh_token_max_reuse, allow_user_managed_access, sso_max_lifespan_remember_me, sso_idle_timeout_remember_me, default_role) FROM stdin;
    public            	   adminmweb    false    268   �x      2          0    25114    realm_attribute 
   TABLE DATA           @   COPY public.realm_attribute (name, realm_id, value) FROM stdin;
    public            	   adminmweb    false    269   {      3          0    25119    realm_default_groups 
   TABLE DATA           B   COPY public.realm_default_groups (realm_id, group_id) FROM stdin;
    public            	   adminmweb    false    270   �      4          0    25122    realm_enabled_event_types 
   TABLE DATA           D   COPY public.realm_enabled_event_types (realm_id, value) FROM stdin;
    public            	   adminmweb    false    271   �      5          0    25125    realm_events_listeners 
   TABLE DATA           A   COPY public.realm_events_listeners (realm_id, value) FROM stdin;
    public            	   adminmweb    false    272   �      6          0    25128    realm_localizations 
   TABLE DATA           F   COPY public.realm_localizations (realm_id, locale, texts) FROM stdin;
    public            	   adminmweb    false    273   M�      7          0    25133    realm_required_credential 
   TABLE DATA           ^   COPY public.realm_required_credential (type, form_label, input, secret, realm_id) FROM stdin;
    public            	   adminmweb    false    274   j�      8          0    25140    realm_smtp_config 
   TABLE DATA           B   COPY public.realm_smtp_config (realm_id, value, name) FROM stdin;
    public            	   adminmweb    false    275   ؀      9          0    25145    realm_supported_locales 
   TABLE DATA           B   COPY public.realm_supported_locales (realm_id, value) FROM stdin;
    public            	   adminmweb    false    276   ��      :          0    25148    redirect_uris 
   TABLE DATA           9   COPY public.redirect_uris (client_id, value) FROM stdin;
    public            	   adminmweb    false    277   :�      ;          0    25151    required_action_config 
   TABLE DATA           Q   COPY public.required_action_config (required_action_id, value, name) FROM stdin;
    public            	   adminmweb    false    278   l�      <          0    25156    required_action_provider 
   TABLE DATA           }   COPY public.required_action_provider (id, alias, name, realm_id, enabled, default_action, provider_id, priority) FROM stdin;
    public            	   adminmweb    false    279   ��      =          0    25163    resource_attribute 
   TABLE DATA           J   COPY public.resource_attribute (id, name, value, resource_id) FROM stdin;
    public            	   adminmweb    false    280   ۅ      >          0    25169    resource_policy 
   TABLE DATA           A   COPY public.resource_policy (resource_id, policy_id) FROM stdin;
    public            	   adminmweb    false    281   ��      ?          0    25172    resource_scope 
   TABLE DATA           ?   COPY public.resource_scope (resource_id, scope_id) FROM stdin;
    public            	   adminmweb    false    282   �      @          0    25175    resource_server 
   TABLE DATA           k   COPY public.resource_server (id, allow_rs_remote_mgmt, policy_enforce_mode, decision_strategy) FROM stdin;
    public            	   adminmweb    false    283   2�      A          0    25180    resource_server_perm_ticket 
   TABLE DATA           �   COPY public.resource_server_perm_ticket (id, owner, requester, created_timestamp, granted_timestamp, resource_id, scope_id, resource_server_id, policy_id) FROM stdin;
    public            	   adminmweb    false    284   y�      B          0    25185    resource_server_policy 
   TABLE DATA           �   COPY public.resource_server_policy (id, name, description, type, decision_strategy, logic, resource_server_id, owner) FROM stdin;
    public            	   adminmweb    false    285   ��      C          0    25190    resource_server_resource 
   TABLE DATA           �   COPY public.resource_server_resource (id, name, type, icon_uri, owner, resource_server_id, owner_managed_access, display_name) FROM stdin;
    public            	   adminmweb    false    286   ~�      D          0    25196    resource_server_scope 
   TABLE DATA           e   COPY public.resource_server_scope (id, name, icon_uri, resource_server_id, display_name) FROM stdin;
    public            	   adminmweb    false    287   �      E          0    25201    resource_uris 
   TABLE DATA           ;   COPY public.resource_uris (resource_id, value) FROM stdin;
    public            	   adminmweb    false    288   ,�      F          0    25204    role_attribute 
   TABLE DATA           B   COPY public.role_attribute (id, role_id, name, value) FROM stdin;
    public            	   adminmweb    false    289   q�      G          0    25209    scope_mapping 
   TABLE DATA           ;   COPY public.scope_mapping (client_id, role_id) FROM stdin;
    public            	   adminmweb    false    290   ��      H          0    25212    scope_policy 
   TABLE DATA           ;   COPY public.scope_policy (scope_id, policy_id) FROM stdin;
    public            	   adminmweb    false    291   ?�      I          0    25215    user_attribute 
   TABLE DATA           B   COPY public.user_attribute (name, value, user_id, id) FROM stdin;
    public            	   adminmweb    false    292   \�      J          0    25221    user_consent 
   TABLE DATA           �   COPY public.user_consent (id, client_id, user_id, created_date, last_updated_date, client_storage_provider, external_client_id) FROM stdin;
    public            	   adminmweb    false    293   y�      K          0    25226    user_consent_client_scope 
   TABLE DATA           N   COPY public.user_consent_client_scope (user_consent_id, scope_id) FROM stdin;
    public            	   adminmweb    false    294   ��      L          0    25229    user_entity 
   TABLE DATA           �   COPY public.user_entity (id, email, email_constraint, email_verified, enabled, federation_link, first_name, last_name, realm_id, username, created_timestamp, service_account_client_link, not_before) FROM stdin;
    public            	   adminmweb    false    295   ��      M          0    25237    user_federation_config 
   TABLE DATA           Z   COPY public.user_federation_config (user_federation_provider_id, value, name) FROM stdin;
    public            	   adminmweb    false    296   o�      N          0    25242    user_federation_mapper 
   TABLE DATA           t   COPY public.user_federation_mapper (id, name, federation_provider_id, federation_mapper_type, realm_id) FROM stdin;
    public            	   adminmweb    false    297   ��      O          0    25247    user_federation_mapper_config 
   TABLE DATA           _   COPY public.user_federation_mapper_config (user_federation_mapper_id, value, name) FROM stdin;
    public            	   adminmweb    false    298   ��      P          0    25252    user_federation_provider 
   TABLE DATA           �   COPY public.user_federation_provider (id, changed_sync_period, display_name, full_sync_period, last_sync, priority, provider_name, realm_id) FROM stdin;
    public            	   adminmweb    false    299   Ƌ      Q          0    25257    user_group_membership 
   TABLE DATA           B   COPY public.user_group_membership (group_id, user_id) FROM stdin;
    public            	   adminmweb    false    300   �      R          0    25260    user_required_action 
   TABLE DATA           H   COPY public.user_required_action (user_id, required_action) FROM stdin;
    public            	   adminmweb    false    301    �      S          0    25264    user_role_mapping 
   TABLE DATA           =   COPY public.user_role_mapping (role_id, user_id) FROM stdin;
    public            	   adminmweb    false    302   �      T          0    25267    user_session 
   TABLE DATA           �   COPY public.user_session (id, auth_method, ip_address, last_session_refresh, login_username, realm_id, remember_me, started, user_id, user_session_state, broker_session_id, broker_user_id) FROM stdin;
    public            	   adminmweb    false    303   ̎      U          0    25273    user_session_note 
   TABLE DATA           F   COPY public.user_session_note (user_session, name, value) FROM stdin;
    public            	   adminmweb    false    304   �      V          0    25278    username_login_failure 
   TABLE DATA           �   COPY public.username_login_failure (realm_id, username, failed_login_not_before, last_failure, last_ip_failure, num_failures) FROM stdin;
    public            	   adminmweb    false    305   �      W          0    25283    web_origins 
   TABLE DATA           7   COPY public.web_origins (client_id, value) FROM stdin;
    public            	   adminmweb    false    306   #�                 2606    25287 &   username_login_failure CONSTRAINT_17-2 
   CONSTRAINT     v   ALTER TABLE ONLY public.username_login_failure
    ADD CONSTRAINT "CONSTRAINT_17-2" PRIMARY KEY (realm_id, username);
 R   ALTER TABLE ONLY public.username_login_failure DROP CONSTRAINT "CONSTRAINT_17-2";
       public              	   adminmweb    false    305    305            �           2606    25289 ,   keycloak_role UK_J3RWUVD56ONTGSUHOGM184WW2-2 
   CONSTRAINT     �   ALTER TABLE ONLY public.keycloak_role
    ADD CONSTRAINT "UK_J3RWUVD56ONTGSUHOGM184WW2-2" UNIQUE (name, client_realm_constraint);
 X   ALTER TABLE ONLY public.keycloak_role DROP CONSTRAINT "UK_J3RWUVD56ONTGSUHOGM184WW2-2";
       public              	   adminmweb    false    261    261                       2606    25291 )   client_auth_flow_bindings c_cli_flow_bind 
   CONSTRAINT     |   ALTER TABLE ONLY public.client_auth_flow_bindings
    ADD CONSTRAINT c_cli_flow_bind PRIMARY KEY (client_id, binding_name);
 S   ALTER TABLE ONLY public.client_auth_flow_bindings DROP CONSTRAINT c_cli_flow_bind;
       public              	   adminmweb    false    224    224            )           2606    25293 $   client_scope_client c_cli_scope_bind 
   CONSTRAINT     s   ALTER TABLE ONLY public.client_scope_client
    ADD CONSTRAINT c_cli_scope_bind PRIMARY KEY (client_id, scope_id);
 N   ALTER TABLE ONLY public.client_scope_client DROP CONSTRAINT c_cli_scope_bind;
       public              	   adminmweb    false    229    229                       2606    25295 .   client_initial_access cnstr_client_init_acc_pk 
   CONSTRAINT     l   ALTER TABLE ONLY public.client_initial_access
    ADD CONSTRAINT cnstr_client_init_acc_pk PRIMARY KEY (id);
 X   ALTER TABLE ONLY public.client_initial_access DROP CONSTRAINT cnstr_client_init_acc_pk;
       public              	   adminmweb    false    225            �           2606    25297 ,   realm_default_groups con_group_id_def_groups 
   CONSTRAINT     k   ALTER TABLE ONLY public.realm_default_groups
    ADD CONSTRAINT con_group_id_def_groups UNIQUE (group_id);
 V   ALTER TABLE ONLY public.realm_default_groups DROP CONSTRAINT con_group_id_def_groups;
       public              	   adminmweb    false    270                       2606    25299 !   broker_link constr_broker_link_pk 
   CONSTRAINT     w   ALTER TABLE ONLY public.broker_link
    ADD CONSTRAINT constr_broker_link_pk PRIMARY KEY (identity_provider, user_id);
 K   ALTER TABLE ONLY public.broker_link DROP CONSTRAINT constr_broker_link_pk;
       public              	   adminmweb    false    221    221            <           2606    25301 /   client_user_session_note constr_cl_usr_ses_note 
   CONSTRAINT        ALTER TABLE ONLY public.client_user_session_note
    ADD CONSTRAINT constr_cl_usr_ses_note PRIMARY KEY (client_session, name);
 Y   ALTER TABLE ONLY public.client_user_session_note DROP CONSTRAINT constr_cl_usr_ses_note;
       public              	   adminmweb    false    236    236            B           2606    25303 +   component_config constr_component_config_pk 
   CONSTRAINT     i   ALTER TABLE ONLY public.component_config
    ADD CONSTRAINT constr_component_config_pk PRIMARY KEY (id);
 U   ALTER TABLE ONLY public.component_config DROP CONSTRAINT constr_component_config_pk;
       public              	   adminmweb    false    238            >           2606    25305    component constr_component_pk 
   CONSTRAINT     [   ALTER TABLE ONLY public.component
    ADD CONSTRAINT constr_component_pk PRIMARY KEY (id);
 G   ALTER TABLE ONLY public.component DROP CONSTRAINT constr_component_pk;
       public              	   adminmweb    false    237            g           2606    25307 3   fed_user_required_action constr_fed_required_action 
   CONSTRAINT     �   ALTER TABLE ONLY public.fed_user_required_action
    ADD CONSTRAINT constr_fed_required_action PRIMARY KEY (required_action, user_id);
 ]   ALTER TABLE ONLY public.fed_user_required_action DROP CONSTRAINT constr_fed_required_action;
       public              	   adminmweb    false    250    250            U           2606    25309 *   fed_user_attribute constr_fed_user_attr_pk 
   CONSTRAINT     h   ALTER TABLE ONLY public.fed_user_attribute
    ADD CONSTRAINT constr_fed_user_attr_pk PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.fed_user_attribute DROP CONSTRAINT constr_fed_user_attr_pk;
       public              	   adminmweb    false    245            X           2606    25311 +   fed_user_consent constr_fed_user_consent_pk 
   CONSTRAINT     i   ALTER TABLE ONLY public.fed_user_consent
    ADD CONSTRAINT constr_fed_user_consent_pk PRIMARY KEY (id);
 U   ALTER TABLE ONLY public.fed_user_consent DROP CONSTRAINT constr_fed_user_consent_pk;
       public              	   adminmweb    false    246            _           2606    25313 +   fed_user_credential constr_fed_user_cred_pk 
   CONSTRAINT     i   ALTER TABLE ONLY public.fed_user_credential
    ADD CONSTRAINT constr_fed_user_cred_pk PRIMARY KEY (id);
 U   ALTER TABLE ONLY public.fed_user_credential DROP CONSTRAINT constr_fed_user_cred_pk;
       public              	   adminmweb    false    248            c           2606    25315 /   fed_user_group_membership constr_fed_user_group 
   CONSTRAINT     |   ALTER TABLE ONLY public.fed_user_group_membership
    ADD CONSTRAINT constr_fed_user_group PRIMARY KEY (group_id, user_id);
 Y   ALTER TABLE ONLY public.fed_user_group_membership DROP CONSTRAINT constr_fed_user_group;
       public              	   adminmweb    false    249    249            k           2606    25317 *   fed_user_role_mapping constr_fed_user_role 
   CONSTRAINT     v   ALTER TABLE ONLY public.fed_user_role_mapping
    ADD CONSTRAINT constr_fed_user_role PRIMARY KEY (role_id, user_id);
 T   ALTER TABLE ONLY public.fed_user_role_mapping DROP CONSTRAINT constr_fed_user_role;
       public              	   adminmweb    false    251    251            s           2606    25319 $   federated_user constr_federated_user 
   CONSTRAINT     b   ALTER TABLE ONLY public.federated_user
    ADD CONSTRAINT constr_federated_user PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.federated_user DROP CONSTRAINT constr_federated_user;
       public              	   adminmweb    false    253            �           2606    25321 0   realm_default_groups constr_realm_default_groups 
   CONSTRAINT     ~   ALTER TABLE ONLY public.realm_default_groups
    ADD CONSTRAINT constr_realm_default_groups PRIMARY KEY (realm_id, group_id);
 Z   ALTER TABLE ONLY public.realm_default_groups DROP CONSTRAINT constr_realm_default_groups;
       public              	   adminmweb    false    270    270            �           2606    25323 8   realm_enabled_event_types constr_realm_enabl_event_types 
   CONSTRAINT     �   ALTER TABLE ONLY public.realm_enabled_event_types
    ADD CONSTRAINT constr_realm_enabl_event_types PRIMARY KEY (realm_id, value);
 b   ALTER TABLE ONLY public.realm_enabled_event_types DROP CONSTRAINT constr_realm_enabl_event_types;
       public              	   adminmweb    false    271    271            �           2606    25325 4   realm_events_listeners constr_realm_events_listeners 
   CONSTRAINT        ALTER TABLE ONLY public.realm_events_listeners
    ADD CONSTRAINT constr_realm_events_listeners PRIMARY KEY (realm_id, value);
 ^   ALTER TABLE ONLY public.realm_events_listeners DROP CONSTRAINT constr_realm_events_listeners;
       public              	   adminmweb    false    272    272            �           2606    25327 6   realm_supported_locales constr_realm_supported_locales 
   CONSTRAINT     �   ALTER TABLE ONLY public.realm_supported_locales
    ADD CONSTRAINT constr_realm_supported_locales PRIMARY KEY (realm_id, value);
 `   ALTER TABLE ONLY public.realm_supported_locales DROP CONSTRAINT constr_realm_supported_locales;
       public              	   adminmweb    false    276    276            |           2606    25329    identity_provider constraint_2b 
   CONSTRAINT     f   ALTER TABLE ONLY public.identity_provider
    ADD CONSTRAINT constraint_2b PRIMARY KEY (internal_id);
 I   ALTER TABLE ONLY public.identity_provider DROP CONSTRAINT constraint_2b;
       public              	   adminmweb    false    256                       2606    25331    client_attributes constraint_3c 
   CONSTRAINT     j   ALTER TABLE ONLY public.client_attributes
    ADD CONSTRAINT constraint_3c PRIMARY KEY (client_id, name);
 I   ALTER TABLE ONLY public.client_attributes DROP CONSTRAINT constraint_3c;
       public              	   adminmweb    false    223    223            R           2606    25333    event_entity constraint_4 
   CONSTRAINT     W   ALTER TABLE ONLY public.event_entity
    ADD CONSTRAINT constraint_4 PRIMARY KEY (id);
 C   ALTER TABLE ONLY public.event_entity DROP CONSTRAINT constraint_4;
       public              	   adminmweb    false    244            o           2606    25335     federated_identity constraint_40 
   CONSTRAINT     v   ALTER TABLE ONLY public.federated_identity
    ADD CONSTRAINT constraint_40 PRIMARY KEY (identity_provider, user_id);
 J   ALTER TABLE ONLY public.federated_identity DROP CONSTRAINT constraint_40;
       public              	   adminmweb    false    252    252            �           2606    25337    realm constraint_4a 
   CONSTRAINT     Q   ALTER TABLE ONLY public.realm
    ADD CONSTRAINT constraint_4a PRIMARY KEY (id);
 =   ALTER TABLE ONLY public.realm DROP CONSTRAINT constraint_4a;
       public              	   adminmweb    false    268            :           2606    25339     client_session_role constraint_5 
   CONSTRAINT     s   ALTER TABLE ONLY public.client_session_role
    ADD CONSTRAINT constraint_5 PRIMARY KEY (client_session, role_id);
 J   ALTER TABLE ONLY public.client_session_role DROP CONSTRAINT constraint_5;
       public              	   adminmweb    false    235    235                       2606    25341    user_session constraint_57 
   CONSTRAINT     X   ALTER TABLE ONLY public.user_session
    ADD CONSTRAINT constraint_57 PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.user_session DROP CONSTRAINT constraint_57;
       public              	   adminmweb    false    303                       2606    25343 &   user_federation_provider constraint_5c 
   CONSTRAINT     d   ALTER TABLE ONLY public.user_federation_provider
    ADD CONSTRAINT constraint_5c PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.user_federation_provider DROP CONSTRAINT constraint_5c;
       public              	   adminmweb    false    299            6           2606    25345 !   client_session_note constraint_5e 
   CONSTRAINT     q   ALTER TABLE ONLY public.client_session_note
    ADD CONSTRAINT constraint_5e PRIMARY KEY (client_session, name);
 K   ALTER TABLE ONLY public.client_session_note DROP CONSTRAINT constraint_5e;
       public              	   adminmweb    false    233    233                       2606    25347    client constraint_7 
   CONSTRAINT     Q   ALTER TABLE ONLY public.client
    ADD CONSTRAINT constraint_7 PRIMARY KEY (id);
 =   ALTER TABLE ONLY public.client DROP CONSTRAINT constraint_7;
       public              	   adminmweb    false    222            1           2606    25349    client_session constraint_8 
   CONSTRAINT     Y   ALTER TABLE ONLY public.client_session
    ADD CONSTRAINT constraint_8 PRIMARY KEY (id);
 E   ALTER TABLE ONLY public.client_session DROP CONSTRAINT constraint_8;
       public              	   adminmweb    false    231            �           2606    25351    scope_mapping constraint_81 
   CONSTRAINT     i   ALTER TABLE ONLY public.scope_mapping
    ADD CONSTRAINT constraint_81 PRIMARY KEY (client_id, role_id);
 E   ALTER TABLE ONLY public.scope_mapping DROP CONSTRAINT constraint_81;
       public              	   adminmweb    false    290    290                       2606    25353 '   client_node_registrations constraint_84 
   CONSTRAINT     r   ALTER TABLE ONLY public.client_node_registrations
    ADD CONSTRAINT constraint_84 PRIMARY KEY (client_id, name);
 Q   ALTER TABLE ONLY public.client_node_registrations DROP CONSTRAINT constraint_84;
       public              	   adminmweb    false    226    226            �           2606    25355    realm_attribute constraint_9 
   CONSTRAINT     f   ALTER TABLE ONLY public.realm_attribute
    ADD CONSTRAINT constraint_9 PRIMARY KEY (name, realm_id);
 F   ALTER TABLE ONLY public.realm_attribute DROP CONSTRAINT constraint_9;
       public              	   adminmweb    false    269    269            �           2606    25357 '   realm_required_credential constraint_92 
   CONSTRAINT     q   ALTER TABLE ONLY public.realm_required_credential
    ADD CONSTRAINT constraint_92 PRIMARY KEY (realm_id, type);
 Q   ALTER TABLE ONLY public.realm_required_credential DROP CONSTRAINT constraint_92;
       public              	   adminmweb    false    274    274            �           2606    25359    keycloak_role constraint_a 
   CONSTRAINT     X   ALTER TABLE ONLY public.keycloak_role
    ADD CONSTRAINT constraint_a PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.keycloak_role DROP CONSTRAINT constraint_a;
       public              	   adminmweb    false    261            �           2606    25361 0   admin_event_entity constraint_admin_event_entity 
   CONSTRAINT     n   ALTER TABLE ONLY public.admin_event_entity
    ADD CONSTRAINT constraint_admin_event_entity PRIMARY KEY (id);
 Z   ALTER TABLE ONLY public.admin_event_entity DROP CONSTRAINT constraint_admin_event_entity;
       public              	   adminmweb    false    215                       2606    25363 1   authenticator_config_entry constraint_auth_cfg_pk 
   CONSTRAINT     �   ALTER TABLE ONLY public.authenticator_config_entry
    ADD CONSTRAINT constraint_auth_cfg_pk PRIMARY KEY (authenticator_id, name);
 [   ALTER TABLE ONLY public.authenticator_config_entry DROP CONSTRAINT constraint_auth_cfg_pk;
       public              	   adminmweb    false    220    220                       2606    25365 0   authentication_execution constraint_auth_exec_pk 
   CONSTRAINT     n   ALTER TABLE ONLY public.authentication_execution
    ADD CONSTRAINT constraint_auth_exec_pk PRIMARY KEY (id);
 Z   ALTER TABLE ONLY public.authentication_execution DROP CONSTRAINT constraint_auth_exec_pk;
       public              	   adminmweb    false    217            	           2606    25367 +   authentication_flow constraint_auth_flow_pk 
   CONSTRAINT     i   ALTER TABLE ONLY public.authentication_flow
    ADD CONSTRAINT constraint_auth_flow_pk PRIMARY KEY (id);
 U   ALTER TABLE ONLY public.authentication_flow DROP CONSTRAINT constraint_auth_flow_pk;
       public              	   adminmweb    false    218                       2606    25369 '   authenticator_config constraint_auth_pk 
   CONSTRAINT     e   ALTER TABLE ONLY public.authenticator_config
    ADD CONSTRAINT constraint_auth_pk PRIMARY KEY (id);
 Q   ALTER TABLE ONLY public.authenticator_config DROP CONSTRAINT constraint_auth_pk;
       public              	   adminmweb    false    219            4           2606    25371 4   client_session_auth_status constraint_auth_status_pk 
   CONSTRAINT     �   ALTER TABLE ONLY public.client_session_auth_status
    ADD CONSTRAINT constraint_auth_status_pk PRIMARY KEY (client_session, authenticator);
 ^   ALTER TABLE ONLY public.client_session_auth_status DROP CONSTRAINT constraint_auth_status_pk;
       public              	   adminmweb    false    232    232                       2606    25373    user_role_mapping constraint_c 
   CONSTRAINT     j   ALTER TABLE ONLY public.user_role_mapping
    ADD CONSTRAINT constraint_c PRIMARY KEY (role_id, user_id);
 H   ALTER TABLE ONLY public.user_role_mapping DROP CONSTRAINT constraint_c;
       public              	   adminmweb    false    302    302            E           2606    25375 (   composite_role constraint_composite_role 
   CONSTRAINT     y   ALTER TABLE ONLY public.composite_role
    ADD CONSTRAINT constraint_composite_role PRIMARY KEY (composite, child_role);
 R   ALTER TABLE ONLY public.composite_role DROP CONSTRAINT constraint_composite_role;
       public              	   adminmweb    false    239    239            8           2606    25377 /   client_session_prot_mapper constraint_cs_pmp_pk 
   CONSTRAINT     �   ALTER TABLE ONLY public.client_session_prot_mapper
    ADD CONSTRAINT constraint_cs_pmp_pk PRIMARY KEY (client_session, protocol_mapper_id);
 Y   ALTER TABLE ONLY public.client_session_prot_mapper DROP CONSTRAINT constraint_cs_pmp_pk;
       public              	   adminmweb    false    234    234            �           2606    25379 %   identity_provider_config constraint_d 
   CONSTRAINT     {   ALTER TABLE ONLY public.identity_provider_config
    ADD CONSTRAINT constraint_d PRIMARY KEY (identity_provider_id, name);
 O   ALTER TABLE ONLY public.identity_provider_config DROP CONSTRAINT constraint_d;
       public              	   adminmweb    false    257    257            �           2606    25381    policy_config constraint_dpc 
   CONSTRAINT     g   ALTER TABLE ONLY public.policy_config
    ADD CONSTRAINT constraint_dpc PRIMARY KEY (policy_id, name);
 F   ALTER TABLE ONLY public.policy_config DROP CONSTRAINT constraint_dpc;
       public              	   adminmweb    false    265    265            �           2606    25383    realm_smtp_config constraint_e 
   CONSTRAINT     h   ALTER TABLE ONLY public.realm_smtp_config
    ADD CONSTRAINT constraint_e PRIMARY KEY (realm_id, name);
 H   ALTER TABLE ONLY public.realm_smtp_config DROP CONSTRAINT constraint_e;
       public              	   adminmweb    false    275    275            I           2606    25385    credential constraint_f 
   CONSTRAINT     U   ALTER TABLE ONLY public.credential
    ADD CONSTRAINT constraint_f PRIMARY KEY (id);
 A   ALTER TABLE ONLY public.credential DROP CONSTRAINT constraint_f;
       public              	   adminmweb    false    240                       2606    25387 $   user_federation_config constraint_f9 
   CONSTRAINT     �   ALTER TABLE ONLY public.user_federation_config
    ADD CONSTRAINT constraint_f9 PRIMARY KEY (user_federation_provider_id, name);
 N   ALTER TABLE ONLY public.user_federation_config DROP CONSTRAINT constraint_f9;
       public              	   adminmweb    false    296    296            �           2606    25389 ,   resource_server_perm_ticket constraint_fapmt 
   CONSTRAINT     j   ALTER TABLE ONLY public.resource_server_perm_ticket
    ADD CONSTRAINT constraint_fapmt PRIMARY KEY (id);
 V   ALTER TABLE ONLY public.resource_server_perm_ticket DROP CONSTRAINT constraint_fapmt;
       public              	   adminmweb    false    284            �           2606    25391 )   resource_server_resource constraint_farsr 
   CONSTRAINT     g   ALTER TABLE ONLY public.resource_server_resource
    ADD CONSTRAINT constraint_farsr PRIMARY KEY (id);
 S   ALTER TABLE ONLY public.resource_server_resource DROP CONSTRAINT constraint_farsr;
       public              	   adminmweb    false    286            �           2606    25393 (   resource_server_policy constraint_farsrp 
   CONSTRAINT     f   ALTER TABLE ONLY public.resource_server_policy
    ADD CONSTRAINT constraint_farsrp PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.resource_server_policy DROP CONSTRAINT constraint_farsrp;
       public              	   adminmweb    false    285                       2606    25395 %   associated_policy constraint_farsrpap 
   CONSTRAINT     �   ALTER TABLE ONLY public.associated_policy
    ADD CONSTRAINT constraint_farsrpap PRIMARY KEY (policy_id, associated_policy_id);
 O   ALTER TABLE ONLY public.associated_policy DROP CONSTRAINT constraint_farsrpap;
       public              	   adminmweb    false    216    216            �           2606    25397 "   resource_policy constraint_farsrpp 
   CONSTRAINT     t   ALTER TABLE ONLY public.resource_policy
    ADD CONSTRAINT constraint_farsrpp PRIMARY KEY (resource_id, policy_id);
 L   ALTER TABLE ONLY public.resource_policy DROP CONSTRAINT constraint_farsrpp;
       public              	   adminmweb    false    281    281            �           2606    25399 '   resource_server_scope constraint_farsrs 
   CONSTRAINT     e   ALTER TABLE ONLY public.resource_server_scope
    ADD CONSTRAINT constraint_farsrs PRIMARY KEY (id);
 Q   ALTER TABLE ONLY public.resource_server_scope DROP CONSTRAINT constraint_farsrs;
       public              	   adminmweb    false    287            �           2606    25401 !   resource_scope constraint_farsrsp 
   CONSTRAINT     r   ALTER TABLE ONLY public.resource_scope
    ADD CONSTRAINT constraint_farsrsp PRIMARY KEY (resource_id, scope_id);
 K   ALTER TABLE ONLY public.resource_scope DROP CONSTRAINT constraint_farsrsp;
       public              	   adminmweb    false    282    282            �           2606    25403     scope_policy constraint_farsrsps 
   CONSTRAINT     o   ALTER TABLE ONLY public.scope_policy
    ADD CONSTRAINT constraint_farsrsps PRIMARY KEY (scope_id, policy_id);
 J   ALTER TABLE ONLY public.scope_policy DROP CONSTRAINT constraint_farsrsps;
       public              	   adminmweb    false    291    291            �           2606    25405    user_entity constraint_fb 
   CONSTRAINT     W   ALTER TABLE ONLY public.user_entity
    ADD CONSTRAINT constraint_fb PRIMARY KEY (id);
 C   ALTER TABLE ONLY public.user_entity DROP CONSTRAINT constraint_fb;
       public              	   adminmweb    false    295                       2606    25407 9   user_federation_mapper_config constraint_fedmapper_cfg_pm 
   CONSTRAINT     �   ALTER TABLE ONLY public.user_federation_mapper_config
    ADD CONSTRAINT constraint_fedmapper_cfg_pm PRIMARY KEY (user_federation_mapper_id, name);
 c   ALTER TABLE ONLY public.user_federation_mapper_config DROP CONSTRAINT constraint_fedmapper_cfg_pm;
       public              	   adminmweb    false    298    298            	           2606    25409 -   user_federation_mapper constraint_fedmapperpm 
   CONSTRAINT     k   ALTER TABLE ONLY public.user_federation_mapper
    ADD CONSTRAINT constraint_fedmapperpm PRIMARY KEY (id);
 W   ALTER TABLE ONLY public.user_federation_mapper DROP CONSTRAINT constraint_fedmapperpm;
       public              	   adminmweb    false    297            ]           2606    25411 6   fed_user_consent_cl_scope constraint_fgrntcsnt_clsc_pm 
   CONSTRAINT     �   ALTER TABLE ONLY public.fed_user_consent_cl_scope
    ADD CONSTRAINT constraint_fgrntcsnt_clsc_pm PRIMARY KEY (user_consent_id, scope_id);
 `   ALTER TABLE ONLY public.fed_user_consent_cl_scope DROP CONSTRAINT constraint_fgrntcsnt_clsc_pm;
       public              	   adminmweb    false    247    247            �           2606    25413 5   user_consent_client_scope constraint_grntcsnt_clsc_pm 
   CONSTRAINT     �   ALTER TABLE ONLY public.user_consent_client_scope
    ADD CONSTRAINT constraint_grntcsnt_clsc_pm PRIMARY KEY (user_consent_id, scope_id);
 _   ALTER TABLE ONLY public.user_consent_client_scope DROP CONSTRAINT constraint_grntcsnt_clsc_pm;
       public              	   adminmweb    false    294    294            �           2606    25415 #   user_consent constraint_grntcsnt_pm 
   CONSTRAINT     a   ALTER TABLE ONLY public.user_consent
    ADD CONSTRAINT constraint_grntcsnt_pm PRIMARY KEY (id);
 M   ALTER TABLE ONLY public.user_consent DROP CONSTRAINT constraint_grntcsnt_pm;
       public              	   adminmweb    false    293            �           2606    25417    keycloak_group constraint_group 
   CONSTRAINT     ]   ALTER TABLE ONLY public.keycloak_group
    ADD CONSTRAINT constraint_group PRIMARY KEY (id);
 I   ALTER TABLE ONLY public.keycloak_group DROP CONSTRAINT constraint_group;
       public              	   adminmweb    false    260            u           2606    25419 -   group_attribute constraint_group_attribute_pk 
   CONSTRAINT     k   ALTER TABLE ONLY public.group_attribute
    ADD CONSTRAINT constraint_group_attribute_pk PRIMARY KEY (id);
 W   ALTER TABLE ONLY public.group_attribute DROP CONSTRAINT constraint_group_attribute_pk;
       public              	   adminmweb    false    254            y           2606    25421 (   group_role_mapping constraint_group_role 
   CONSTRAINT     u   ALTER TABLE ONLY public.group_role_mapping
    ADD CONSTRAINT constraint_group_role PRIMARY KEY (role_id, group_id);
 R   ALTER TABLE ONLY public.group_role_mapping DROP CONSTRAINT constraint_group_role;
       public              	   adminmweb    false    255    255            �           2606    25423 (   identity_provider_mapper constraint_idpm 
   CONSTRAINT     f   ALTER TABLE ONLY public.identity_provider_mapper
    ADD CONSTRAINT constraint_idpm PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.identity_provider_mapper DROP CONSTRAINT constraint_idpm;
       public              	   adminmweb    false    258            �           2606    25425 '   idp_mapper_config constraint_idpmconfig 
   CONSTRAINT     v   ALTER TABLE ONLY public.idp_mapper_config
    ADD CONSTRAINT constraint_idpmconfig PRIMARY KEY (idp_mapper_id, name);
 Q   ALTER TABLE ONLY public.idp_mapper_config DROP CONSTRAINT constraint_idpmconfig;
       public              	   adminmweb    false    259    259            �           2606    25427 !   migration_model constraint_migmod 
   CONSTRAINT     _   ALTER TABLE ONLY public.migration_model
    ADD CONSTRAINT constraint_migmod PRIMARY KEY (id);
 K   ALTER TABLE ONLY public.migration_model DROP CONSTRAINT constraint_migmod;
       public              	   adminmweb    false    262            �           2606    25429 1   offline_client_session constraint_offl_cl_ses_pk3 
   CONSTRAINT     �   ALTER TABLE ONLY public.offline_client_session
    ADD CONSTRAINT constraint_offl_cl_ses_pk3 PRIMARY KEY (user_session_id, client_id, client_storage_provider, external_client_id, offline_flag);
 [   ALTER TABLE ONLY public.offline_client_session DROP CONSTRAINT constraint_offl_cl_ses_pk3;
       public              	   adminmweb    false    263    263    263    263    263            �           2606    25431 /   offline_user_session constraint_offl_us_ses_pk2 
   CONSTRAINT     �   ALTER TABLE ONLY public.offline_user_session
    ADD CONSTRAINT constraint_offl_us_ses_pk2 PRIMARY KEY (user_session_id, offline_flag);
 Y   ALTER TABLE ONLY public.offline_user_session DROP CONSTRAINT constraint_offl_us_ses_pk2;
       public              	   adminmweb    false    264    264            �           2606    25433    protocol_mapper constraint_pcm 
   CONSTRAINT     \   ALTER TABLE ONLY public.protocol_mapper
    ADD CONSTRAINT constraint_pcm PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.protocol_mapper DROP CONSTRAINT constraint_pcm;
       public              	   adminmweb    false    266            �           2606    25435 *   protocol_mapper_config constraint_pmconfig 
   CONSTRAINT     ~   ALTER TABLE ONLY public.protocol_mapper_config
    ADD CONSTRAINT constraint_pmconfig PRIMARY KEY (protocol_mapper_id, name);
 T   ALTER TABLE ONLY public.protocol_mapper_config DROP CONSTRAINT constraint_pmconfig;
       public              	   adminmweb    false    267    267            �           2606    25437 &   redirect_uris constraint_redirect_uris 
   CONSTRAINT     r   ALTER TABLE ONLY public.redirect_uris
    ADD CONSTRAINT constraint_redirect_uris PRIMARY KEY (client_id, value);
 P   ALTER TABLE ONLY public.redirect_uris DROP CONSTRAINT constraint_redirect_uris;
       public              	   adminmweb    false    277    277            �           2606    25439 0   required_action_config constraint_req_act_cfg_pk 
   CONSTRAINT     �   ALTER TABLE ONLY public.required_action_config
    ADD CONSTRAINT constraint_req_act_cfg_pk PRIMARY KEY (required_action_id, name);
 Z   ALTER TABLE ONLY public.required_action_config DROP CONSTRAINT constraint_req_act_cfg_pk;
       public              	   adminmweb    false    278    278            �           2606    25441 2   required_action_provider constraint_req_act_prv_pk 
   CONSTRAINT     p   ALTER TABLE ONLY public.required_action_provider
    ADD CONSTRAINT constraint_req_act_prv_pk PRIMARY KEY (id);
 \   ALTER TABLE ONLY public.required_action_provider DROP CONSTRAINT constraint_req_act_prv_pk;
       public              	   adminmweb    false    279                       2606    25443 /   user_required_action constraint_required_action 
   CONSTRAINT     �   ALTER TABLE ONLY public.user_required_action
    ADD CONSTRAINT constraint_required_action PRIMARY KEY (required_action, user_id);
 Y   ALTER TABLE ONLY public.user_required_action DROP CONSTRAINT constraint_required_action;
       public              	   adminmweb    false    301    301            �           2606    25445 '   resource_uris constraint_resour_uris_pk 
   CONSTRAINT     u   ALTER TABLE ONLY public.resource_uris
    ADD CONSTRAINT constraint_resour_uris_pk PRIMARY KEY (resource_id, value);
 Q   ALTER TABLE ONLY public.resource_uris DROP CONSTRAINT constraint_resour_uris_pk;
       public              	   adminmweb    false    288    288            �           2606    25447 +   role_attribute constraint_role_attribute_pk 
   CONSTRAINT     i   ALTER TABLE ONLY public.role_attribute
    ADD CONSTRAINT constraint_role_attribute_pk PRIMARY KEY (id);
 U   ALTER TABLE ONLY public.role_attribute DROP CONSTRAINT constraint_role_attribute_pk;
       public              	   adminmweb    false    289            �           2606    25449 +   user_attribute constraint_user_attribute_pk 
   CONSTRAINT     i   ALTER TABLE ONLY public.user_attribute
    ADD CONSTRAINT constraint_user_attribute_pk PRIMARY KEY (id);
 U   ALTER TABLE ONLY public.user_attribute DROP CONSTRAINT constraint_user_attribute_pk;
       public              	   adminmweb    false    292                       2606    25451 +   user_group_membership constraint_user_group 
   CONSTRAINT     x   ALTER TABLE ONLY public.user_group_membership
    ADD CONSTRAINT constraint_user_group PRIMARY KEY (group_id, user_id);
 U   ALTER TABLE ONLY public.user_group_membership DROP CONSTRAINT constraint_user_group;
       public              	   adminmweb    false    300    300                       2606    25453 #   user_session_note constraint_usn_pk 
   CONSTRAINT     q   ALTER TABLE ONLY public.user_session_note
    ADD CONSTRAINT constraint_usn_pk PRIMARY KEY (user_session, name);
 M   ALTER TABLE ONLY public.user_session_note DROP CONSTRAINT constraint_usn_pk;
       public              	   adminmweb    false    304    304            !           2606    25455 "   web_origins constraint_web_origins 
   CONSTRAINT     n   ALTER TABLE ONLY public.web_origins
    ADD CONSTRAINT constraint_web_origins PRIMARY KEY (client_id, value);
 L   ALTER TABLE ONLY public.web_origins DROP CONSTRAINT constraint_web_origins;
       public              	   adminmweb    false    306    306            L           2606    25457 0   databasechangeloglock databasechangeloglock_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.databasechangeloglock
    ADD CONSTRAINT databasechangeloglock_pkey PRIMARY KEY (id);
 Z   ALTER TABLE ONLY public.databasechangeloglock DROP CONSTRAINT databasechangeloglock_pkey;
       public              	   adminmweb    false    242            '           2606    25459 '   client_scope_attributes pk_cl_tmpl_attr 
   CONSTRAINT     q   ALTER TABLE ONLY public.client_scope_attributes
    ADD CONSTRAINT pk_cl_tmpl_attr PRIMARY KEY (scope_id, name);
 Q   ALTER TABLE ONLY public.client_scope_attributes DROP CONSTRAINT pk_cl_tmpl_attr;
       public              	   adminmweb    false    228    228            "           2606    25461    client_scope pk_cli_template 
   CONSTRAINT     Z   ALTER TABLE ONLY public.client_scope
    ADD CONSTRAINT pk_cli_template PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.client_scope DROP CONSTRAINT pk_cli_template;
       public              	   adminmweb    false    227            �           2606    25463 "   resource_server pk_resource_server 
   CONSTRAINT     `   ALTER TABLE ONLY public.resource_server
    ADD CONSTRAINT pk_resource_server PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.resource_server DROP CONSTRAINT pk_resource_server;
       public              	   adminmweb    false    283            /           2606    25465 +   client_scope_role_mapping pk_template_scope 
   CONSTRAINT     x   ALTER TABLE ONLY public.client_scope_role_mapping
    ADD CONSTRAINT pk_template_scope PRIMARY KEY (scope_id, role_id);
 U   ALTER TABLE ONLY public.client_scope_role_mapping DROP CONSTRAINT pk_template_scope;
       public              	   adminmweb    false    230    230            P           2606    25467 )   default_client_scope r_def_cli_scope_bind 
   CONSTRAINT     w   ALTER TABLE ONLY public.default_client_scope
    ADD CONSTRAINT r_def_cli_scope_bind PRIMARY KEY (realm_id, scope_id);
 S   ALTER TABLE ONLY public.default_client_scope DROP CONSTRAINT r_def_cli_scope_bind;
       public              	   adminmweb    false    243    243            �           2606    25469 ,   realm_localizations realm_localizations_pkey 
   CONSTRAINT     x   ALTER TABLE ONLY public.realm_localizations
    ADD CONSTRAINT realm_localizations_pkey PRIMARY KEY (realm_id, locale);
 V   ALTER TABLE ONLY public.realm_localizations DROP CONSTRAINT realm_localizations_pkey;
       public              	   adminmweb    false    273    273            �           2606    25471    resource_attribute res_attr_pk 
   CONSTRAINT     \   ALTER TABLE ONLY public.resource_attribute
    ADD CONSTRAINT res_attr_pk PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.resource_attribute DROP CONSTRAINT res_attr_pk;
       public              	   adminmweb    false    280            �           2606    25473    keycloak_group sibling_names 
   CONSTRAINT     o   ALTER TABLE ONLY public.keycloak_group
    ADD CONSTRAINT sibling_names UNIQUE (realm_id, parent_group, name);
 F   ALTER TABLE ONLY public.keycloak_group DROP CONSTRAINT sibling_names;
       public              	   adminmweb    false    260    260    260                       2606    25475 /   identity_provider uk_2daelwnibji49avxsrtuf6xj33 
   CONSTRAINT     ~   ALTER TABLE ONLY public.identity_provider
    ADD CONSTRAINT uk_2daelwnibji49avxsrtuf6xj33 UNIQUE (provider_alias, realm_id);
 Y   ALTER TABLE ONLY public.identity_provider DROP CONSTRAINT uk_2daelwnibji49avxsrtuf6xj33;
       public              	   adminmweb    false    256    256                       2606    25477 #   client uk_b71cjlbenv945rb6gcon438at 
   CONSTRAINT     m   ALTER TABLE ONLY public.client
    ADD CONSTRAINT uk_b71cjlbenv945rb6gcon438at UNIQUE (realm_id, client_id);
 M   ALTER TABLE ONLY public.client DROP CONSTRAINT uk_b71cjlbenv945rb6gcon438at;
       public              	   adminmweb    false    222    222            $           2606    25479    client_scope uk_cli_scope 
   CONSTRAINT     ^   ALTER TABLE ONLY public.client_scope
    ADD CONSTRAINT uk_cli_scope UNIQUE (realm_id, name);
 C   ALTER TABLE ONLY public.client_scope DROP CONSTRAINT uk_cli_scope;
       public              	   adminmweb    false    227    227                       2606    25481 (   user_entity uk_dykn684sl8up1crfei6eckhd7 
   CONSTRAINT     y   ALTER TABLE ONLY public.user_entity
    ADD CONSTRAINT uk_dykn684sl8up1crfei6eckhd7 UNIQUE (realm_id, email_constraint);
 R   ALTER TABLE ONLY public.user_entity DROP CONSTRAINT uk_dykn684sl8up1crfei6eckhd7;
       public              	   adminmweb    false    295    295            �           2606    25483 4   resource_server_resource uk_frsr6t700s9v50bu18ws5ha6 
   CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_resource
    ADD CONSTRAINT uk_frsr6t700s9v50bu18ws5ha6 UNIQUE (name, owner, resource_server_id);
 ^   ALTER TABLE ONLY public.resource_server_resource DROP CONSTRAINT uk_frsr6t700s9v50bu18ws5ha6;
       public              	   adminmweb    false    286    286    286            �           2606    25485 7   resource_server_perm_ticket uk_frsr6t700s9v50bu18ws5pmt 
   CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_perm_ticket
    ADD CONSTRAINT uk_frsr6t700s9v50bu18ws5pmt UNIQUE (owner, requester, resource_server_id, resource_id, scope_id);
 a   ALTER TABLE ONLY public.resource_server_perm_ticket DROP CONSTRAINT uk_frsr6t700s9v50bu18ws5pmt;
       public              	   adminmweb    false    284    284    284    284    284            �           2606    25487 2   resource_server_policy uk_frsrpt700s9v50bu18ws5ha6 
   CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_policy
    ADD CONSTRAINT uk_frsrpt700s9v50bu18ws5ha6 UNIQUE (name, resource_server_id);
 \   ALTER TABLE ONLY public.resource_server_policy DROP CONSTRAINT uk_frsrpt700s9v50bu18ws5ha6;
       public              	   adminmweb    false    285    285            �           2606    25489 1   resource_server_scope uk_frsrst700s9v50bu18ws5ha6 
   CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_scope
    ADD CONSTRAINT uk_frsrst700s9v50bu18ws5ha6 UNIQUE (name, resource_server_id);
 [   ALTER TABLE ONLY public.resource_server_scope DROP CONSTRAINT uk_frsrst700s9v50bu18ws5ha6;
       public              	   adminmweb    false    287    287            �           2606    25491 )   user_consent uk_jkuwuvd56ontgsuhogm8uewrt 
   CONSTRAINT     �   ALTER TABLE ONLY public.user_consent
    ADD CONSTRAINT uk_jkuwuvd56ontgsuhogm8uewrt UNIQUE (client_id, client_storage_provider, external_client_id, user_id);
 S   ALTER TABLE ONLY public.user_consent DROP CONSTRAINT uk_jkuwuvd56ontgsuhogm8uewrt;
       public              	   adminmweb    false    293    293    293    293            �           2606    25493 "   realm uk_orvsdmla56612eaefiq6wl5oi 
   CONSTRAINT     ]   ALTER TABLE ONLY public.realm
    ADD CONSTRAINT uk_orvsdmla56612eaefiq6wl5oi UNIQUE (name);
 L   ALTER TABLE ONLY public.realm DROP CONSTRAINT uk_orvsdmla56612eaefiq6wl5oi;
       public              	   adminmweb    false    268                       2606    25495 (   user_entity uk_ru8tt6t700s9v50bu18ws5ha6 
   CONSTRAINT     q   ALTER TABLE ONLY public.user_entity
    ADD CONSTRAINT uk_ru8tt6t700s9v50bu18ws5ha6 UNIQUE (realm_id, username);
 R   ALTER TABLE ONLY public.user_entity DROP CONSTRAINT uk_ru8tt6t700s9v50bu18ws5ha6;
       public              	   adminmweb    false    295    295                        1259    25496    idx_admin_event_time    INDEX     i   CREATE INDEX idx_admin_event_time ON public.admin_event_entity USING btree (realm_id, admin_event_time);
 (   DROP INDEX public.idx_admin_event_time;
       public              	   adminmweb    false    215    215                       1259    25497    idx_assoc_pol_assoc_pol_id    INDEX     h   CREATE INDEX idx_assoc_pol_assoc_pol_id ON public.associated_policy USING btree (associated_policy_id);
 .   DROP INDEX public.idx_assoc_pol_assoc_pol_id;
       public              	   adminmweb    false    216                       1259    25498    idx_auth_config_realm    INDEX     Z   CREATE INDEX idx_auth_config_realm ON public.authenticator_config USING btree (realm_id);
 )   DROP INDEX public.idx_auth_config_realm;
       public              	   adminmweb    false    219                       1259    25499    idx_auth_exec_flow    INDEX     Z   CREATE INDEX idx_auth_exec_flow ON public.authentication_execution USING btree (flow_id);
 &   DROP INDEX public.idx_auth_exec_flow;
       public              	   adminmweb    false    217                       1259    25500    idx_auth_exec_realm_flow    INDEX     j   CREATE INDEX idx_auth_exec_realm_flow ON public.authentication_execution USING btree (realm_id, flow_id);
 ,   DROP INDEX public.idx_auth_exec_realm_flow;
       public              	   adminmweb    false    217    217            
           1259    25501    idx_auth_flow_realm    INDEX     W   CREATE INDEX idx_auth_flow_realm ON public.authentication_flow USING btree (realm_id);
 '   DROP INDEX public.idx_auth_flow_realm;
       public              	   adminmweb    false    218            *           1259    25502    idx_cl_clscope    INDEX     R   CREATE INDEX idx_cl_clscope ON public.client_scope_client USING btree (scope_id);
 "   DROP INDEX public.idx_cl_clscope;
       public              	   adminmweb    false    229                       1259    25503    idx_client_id    INDEX     E   CREATE INDEX idx_client_id ON public.client USING btree (client_id);
 !   DROP INDEX public.idx_client_id;
       public              	   adminmweb    false    222                       1259    25504    idx_client_init_acc_realm    INDEX     _   CREATE INDEX idx_client_init_acc_realm ON public.client_initial_access USING btree (realm_id);
 -   DROP INDEX public.idx_client_init_acc_realm;
       public              	   adminmweb    false    225            2           1259    25505    idx_client_session_session    INDEX     [   CREATE INDEX idx_client_session_session ON public.client_session USING btree (session_id);
 .   DROP INDEX public.idx_client_session_session;
       public              	   adminmweb    false    231            %           1259    25506    idx_clscope_attrs    INDEX     Y   CREATE INDEX idx_clscope_attrs ON public.client_scope_attributes USING btree (scope_id);
 %   DROP INDEX public.idx_clscope_attrs;
       public              	   adminmweb    false    228            +           1259    25507    idx_clscope_cl    INDEX     S   CREATE INDEX idx_clscope_cl ON public.client_scope_client USING btree (client_id);
 "   DROP INDEX public.idx_clscope_cl;
       public              	   adminmweb    false    229            �           1259    25508    idx_clscope_protmap    INDEX     Z   CREATE INDEX idx_clscope_protmap ON public.protocol_mapper USING btree (client_scope_id);
 '   DROP INDEX public.idx_clscope_protmap;
       public              	   adminmweb    false    266            ,           1259    25509    idx_clscope_role    INDEX     Z   CREATE INDEX idx_clscope_role ON public.client_scope_role_mapping USING btree (scope_id);
 $   DROP INDEX public.idx_clscope_role;
       public              	   adminmweb    false    230            C           1259    25510    idx_compo_config_compo    INDEX     [   CREATE INDEX idx_compo_config_compo ON public.component_config USING btree (component_id);
 *   DROP INDEX public.idx_compo_config_compo;
       public              	   adminmweb    false    238            ?           1259    25511    idx_component_provider_type    INDEX     Z   CREATE INDEX idx_component_provider_type ON public.component USING btree (provider_type);
 /   DROP INDEX public.idx_component_provider_type;
       public              	   adminmweb    false    237            @           1259    25512    idx_component_realm    INDEX     M   CREATE INDEX idx_component_realm ON public.component USING btree (realm_id);
 '   DROP INDEX public.idx_component_realm;
       public              	   adminmweb    false    237            F           1259    25513    idx_composite    INDEX     M   CREATE INDEX idx_composite ON public.composite_role USING btree (composite);
 !   DROP INDEX public.idx_composite;
       public              	   adminmweb    false    239            G           1259    25514    idx_composite_child    INDEX     T   CREATE INDEX idx_composite_child ON public.composite_role USING btree (child_role);
 '   DROP INDEX public.idx_composite_child;
       public              	   adminmweb    false    239            M           1259    25515    idx_defcls_realm    INDEX     U   CREATE INDEX idx_defcls_realm ON public.default_client_scope USING btree (realm_id);
 $   DROP INDEX public.idx_defcls_realm;
       public              	   adminmweb    false    243            N           1259    25516    idx_defcls_scope    INDEX     U   CREATE INDEX idx_defcls_scope ON public.default_client_scope USING btree (scope_id);
 $   DROP INDEX public.idx_defcls_scope;
       public              	   adminmweb    false    243            S           1259    25517    idx_event_time    INDEX     W   CREATE INDEX idx_event_time ON public.event_entity USING btree (realm_id, event_time);
 "   DROP INDEX public.idx_event_time;
       public              	   adminmweb    false    244    244            p           1259    25518    idx_fedidentity_feduser    INDEX     c   CREATE INDEX idx_fedidentity_feduser ON public.federated_identity USING btree (federated_user_id);
 +   DROP INDEX public.idx_fedidentity_feduser;
       public              	   adminmweb    false    252            q           1259    25519    idx_fedidentity_user    INDEX     V   CREATE INDEX idx_fedidentity_user ON public.federated_identity USING btree (user_id);
 (   DROP INDEX public.idx_fedidentity_user;
       public              	   adminmweb    false    252            V           1259    25520    idx_fu_attribute    INDEX     b   CREATE INDEX idx_fu_attribute ON public.fed_user_attribute USING btree (user_id, realm_id, name);
 $   DROP INDEX public.idx_fu_attribute;
       public              	   adminmweb    false    245    245    245            Y           1259    25521    idx_fu_cnsnt_ext    INDEX     }   CREATE INDEX idx_fu_cnsnt_ext ON public.fed_user_consent USING btree (user_id, client_storage_provider, external_client_id);
 $   DROP INDEX public.idx_fu_cnsnt_ext;
       public              	   adminmweb    false    246    246    246            Z           1259    25522    idx_fu_consent    INDEX     Y   CREATE INDEX idx_fu_consent ON public.fed_user_consent USING btree (user_id, client_id);
 "   DROP INDEX public.idx_fu_consent;
       public              	   adminmweb    false    246    246            [           1259    25523    idx_fu_consent_ru    INDEX     [   CREATE INDEX idx_fu_consent_ru ON public.fed_user_consent USING btree (realm_id, user_id);
 %   DROP INDEX public.idx_fu_consent_ru;
       public              	   adminmweb    false    246    246            `           1259    25524    idx_fu_credential    INDEX     Z   CREATE INDEX idx_fu_credential ON public.fed_user_credential USING btree (user_id, type);
 %   DROP INDEX public.idx_fu_credential;
       public              	   adminmweb    false    248    248            a           1259    25525    idx_fu_credential_ru    INDEX     a   CREATE INDEX idx_fu_credential_ru ON public.fed_user_credential USING btree (realm_id, user_id);
 (   DROP INDEX public.idx_fu_credential_ru;
       public              	   adminmweb    false    248    248            d           1259    25526    idx_fu_group_membership    INDEX     j   CREATE INDEX idx_fu_group_membership ON public.fed_user_group_membership USING btree (user_id, group_id);
 +   DROP INDEX public.idx_fu_group_membership;
       public              	   adminmweb    false    249    249            e           1259    25527    idx_fu_group_membership_ru    INDEX     m   CREATE INDEX idx_fu_group_membership_ru ON public.fed_user_group_membership USING btree (realm_id, user_id);
 .   DROP INDEX public.idx_fu_group_membership_ru;
       public              	   adminmweb    false    249    249            h           1259    25528    idx_fu_required_action    INDEX     o   CREATE INDEX idx_fu_required_action ON public.fed_user_required_action USING btree (user_id, required_action);
 *   DROP INDEX public.idx_fu_required_action;
       public              	   adminmweb    false    250    250            i           1259    25529    idx_fu_required_action_ru    INDEX     k   CREATE INDEX idx_fu_required_action_ru ON public.fed_user_required_action USING btree (realm_id, user_id);
 -   DROP INDEX public.idx_fu_required_action_ru;
       public              	   adminmweb    false    250    250            l           1259    25530    idx_fu_role_mapping    INDEX     a   CREATE INDEX idx_fu_role_mapping ON public.fed_user_role_mapping USING btree (user_id, role_id);
 '   DROP INDEX public.idx_fu_role_mapping;
       public              	   adminmweb    false    251    251            m           1259    25531    idx_fu_role_mapping_ru    INDEX     e   CREATE INDEX idx_fu_role_mapping_ru ON public.fed_user_role_mapping USING btree (realm_id, user_id);
 *   DROP INDEX public.idx_fu_role_mapping_ru;
       public              	   adminmweb    false    251    251            v           1259    25532    idx_group_att_by_name_value    INDEX     z   CREATE INDEX idx_group_att_by_name_value ON public.group_attribute USING btree (name, ((value)::character varying(250)));
 /   DROP INDEX public.idx_group_att_by_name_value;
       public              	   adminmweb    false    254    254            w           1259    25533    idx_group_attr_group    INDEX     T   CREATE INDEX idx_group_attr_group ON public.group_attribute USING btree (group_id);
 (   DROP INDEX public.idx_group_attr_group;
       public              	   adminmweb    false    254            z           1259    25534    idx_group_role_mapp_group    INDEX     \   CREATE INDEX idx_group_role_mapp_group ON public.group_role_mapping USING btree (group_id);
 -   DROP INDEX public.idx_group_role_mapp_group;
       public              	   adminmweb    false    255            �           1259    25535    idx_id_prov_mapp_realm    INDEX     _   CREATE INDEX idx_id_prov_mapp_realm ON public.identity_provider_mapper USING btree (realm_id);
 *   DROP INDEX public.idx_id_prov_mapp_realm;
       public              	   adminmweb    false    258            }           1259    25536    idx_ident_prov_realm    INDEX     V   CREATE INDEX idx_ident_prov_realm ON public.identity_provider USING btree (realm_id);
 (   DROP INDEX public.idx_ident_prov_realm;
       public              	   adminmweb    false    256            �           1259    25537    idx_keycloak_role_client    INDEX     T   CREATE INDEX idx_keycloak_role_client ON public.keycloak_role USING btree (client);
 ,   DROP INDEX public.idx_keycloak_role_client;
       public              	   adminmweb    false    261            �           1259    25538    idx_keycloak_role_realm    INDEX     R   CREATE INDEX idx_keycloak_role_realm ON public.keycloak_role USING btree (realm);
 +   DROP INDEX public.idx_keycloak_role_realm;
       public              	   adminmweb    false    261            �           1259    25539    idx_offline_css_preload    INDEX     m   CREATE INDEX idx_offline_css_preload ON public.offline_client_session USING btree (client_id, offline_flag);
 +   DROP INDEX public.idx_offline_css_preload;
       public              	   adminmweb    false    263    263            �           1259    25540    idx_offline_uss_by_user    INDEX     s   CREATE INDEX idx_offline_uss_by_user ON public.offline_user_session USING btree (user_id, realm_id, offline_flag);
 +   DROP INDEX public.idx_offline_uss_by_user;
       public              	   adminmweb    false    264    264    264            �           1259    25541    idx_offline_uss_by_usersess    INDEX        CREATE INDEX idx_offline_uss_by_usersess ON public.offline_user_session USING btree (realm_id, offline_flag, user_session_id);
 /   DROP INDEX public.idx_offline_uss_by_usersess;
       public              	   adminmweb    false    264    264    264            �           1259    25542    idx_offline_uss_createdon    INDEX     `   CREATE INDEX idx_offline_uss_createdon ON public.offline_user_session USING btree (created_on);
 -   DROP INDEX public.idx_offline_uss_createdon;
       public              	   adminmweb    false    264            �           1259    25543    idx_offline_uss_preload    INDEX     }   CREATE INDEX idx_offline_uss_preload ON public.offline_user_session USING btree (offline_flag, created_on, user_session_id);
 +   DROP INDEX public.idx_offline_uss_preload;
       public              	   adminmweb    false    264    264    264            �           1259    25544    idx_protocol_mapper_client    INDEX     [   CREATE INDEX idx_protocol_mapper_client ON public.protocol_mapper USING btree (client_id);
 .   DROP INDEX public.idx_protocol_mapper_client;
       public              	   adminmweb    false    266            �           1259    25545    idx_realm_attr_realm    INDEX     T   CREATE INDEX idx_realm_attr_realm ON public.realm_attribute USING btree (realm_id);
 (   DROP INDEX public.idx_realm_attr_realm;
       public              	   adminmweb    false    269                        1259    25546    idx_realm_clscope    INDEX     N   CREATE INDEX idx_realm_clscope ON public.client_scope USING btree (realm_id);
 %   DROP INDEX public.idx_realm_clscope;
       public              	   adminmweb    false    227            �           1259    25547    idx_realm_def_grp_realm    INDEX     \   CREATE INDEX idx_realm_def_grp_realm ON public.realm_default_groups USING btree (realm_id);
 +   DROP INDEX public.idx_realm_def_grp_realm;
       public              	   adminmweb    false    270            �           1259    25548    idx_realm_evt_list_realm    INDEX     _   CREATE INDEX idx_realm_evt_list_realm ON public.realm_events_listeners USING btree (realm_id);
 ,   DROP INDEX public.idx_realm_evt_list_realm;
       public              	   adminmweb    false    272            �           1259    25549    idx_realm_evt_types_realm    INDEX     c   CREATE INDEX idx_realm_evt_types_realm ON public.realm_enabled_event_types USING btree (realm_id);
 -   DROP INDEX public.idx_realm_evt_types_realm;
       public              	   adminmweb    false    271            �           1259    25550    idx_realm_master_adm_cli    INDEX     Y   CREATE INDEX idx_realm_master_adm_cli ON public.realm USING btree (master_admin_client);
 ,   DROP INDEX public.idx_realm_master_adm_cli;
       public              	   adminmweb    false    268            �           1259    25551    idx_realm_supp_local_realm    INDEX     b   CREATE INDEX idx_realm_supp_local_realm ON public.realm_supported_locales USING btree (realm_id);
 .   DROP INDEX public.idx_realm_supp_local_realm;
       public              	   adminmweb    false    276            �           1259    25552    idx_redir_uri_client    INDEX     S   CREATE INDEX idx_redir_uri_client ON public.redirect_uris USING btree (client_id);
 (   DROP INDEX public.idx_redir_uri_client;
       public              	   adminmweb    false    277            �           1259    25553    idx_req_act_prov_realm    INDEX     _   CREATE INDEX idx_req_act_prov_realm ON public.required_action_provider USING btree (realm_id);
 *   DROP INDEX public.idx_req_act_prov_realm;
       public              	   adminmweb    false    279            �           1259    25554    idx_res_policy_policy    INDEX     V   CREATE INDEX idx_res_policy_policy ON public.resource_policy USING btree (policy_id);
 )   DROP INDEX public.idx_res_policy_policy;
       public              	   adminmweb    false    281            �           1259    25555    idx_res_scope_scope    INDEX     R   CREATE INDEX idx_res_scope_scope ON public.resource_scope USING btree (scope_id);
 '   DROP INDEX public.idx_res_scope_scope;
       public              	   adminmweb    false    282            �           1259    25556    idx_res_serv_pol_res_serv    INDEX     j   CREATE INDEX idx_res_serv_pol_res_serv ON public.resource_server_policy USING btree (resource_server_id);
 -   DROP INDEX public.idx_res_serv_pol_res_serv;
       public              	   adminmweb    false    285            �           1259    25557    idx_res_srv_res_res_srv    INDEX     j   CREATE INDEX idx_res_srv_res_res_srv ON public.resource_server_resource USING btree (resource_server_id);
 +   DROP INDEX public.idx_res_srv_res_res_srv;
       public              	   adminmweb    false    286            �           1259    25558    idx_res_srv_scope_res_srv    INDEX     i   CREATE INDEX idx_res_srv_scope_res_srv ON public.resource_server_scope USING btree (resource_server_id);
 -   DROP INDEX public.idx_res_srv_scope_res_srv;
       public              	   adminmweb    false    287            �           1259    25559    idx_role_attribute    INDEX     P   CREATE INDEX idx_role_attribute ON public.role_attribute USING btree (role_id);
 &   DROP INDEX public.idx_role_attribute;
       public              	   adminmweb    false    289            -           1259    25560    idx_role_clscope    INDEX     Y   CREATE INDEX idx_role_clscope ON public.client_scope_role_mapping USING btree (role_id);
 $   DROP INDEX public.idx_role_clscope;
       public              	   adminmweb    false    230            �           1259    25561    idx_scope_mapping_role    INDEX     S   CREATE INDEX idx_scope_mapping_role ON public.scope_mapping USING btree (role_id);
 *   DROP INDEX public.idx_scope_mapping_role;
       public              	   adminmweb    false    290            �           1259    25562    idx_scope_policy_policy    INDEX     U   CREATE INDEX idx_scope_policy_policy ON public.scope_policy USING btree (policy_id);
 +   DROP INDEX public.idx_scope_policy_policy;
       public              	   adminmweb    false    291            �           1259    25563    idx_update_time    INDEX     R   CREATE INDEX idx_update_time ON public.migration_model USING btree (update_time);
 #   DROP INDEX public.idx_update_time;
       public              	   adminmweb    false    262            �           1259    25564    idx_us_sess_id_on_cl_sess    INDEX     g   CREATE INDEX idx_us_sess_id_on_cl_sess ON public.offline_client_session USING btree (user_session_id);
 -   DROP INDEX public.idx_us_sess_id_on_cl_sess;
       public              	   adminmweb    false    263            �           1259    25565    idx_usconsent_clscope    INDEX     f   CREATE INDEX idx_usconsent_clscope ON public.user_consent_client_scope USING btree (user_consent_id);
 )   DROP INDEX public.idx_usconsent_clscope;
       public              	   adminmweb    false    294            �           1259    25566    idx_user_attribute    INDEX     P   CREATE INDEX idx_user_attribute ON public.user_attribute USING btree (user_id);
 &   DROP INDEX public.idx_user_attribute;
       public              	   adminmweb    false    292            �           1259    25567    idx_user_attribute_name    INDEX     Y   CREATE INDEX idx_user_attribute_name ON public.user_attribute USING btree (name, value);
 +   DROP INDEX public.idx_user_attribute_name;
       public              	   adminmweb    false    292    292            �           1259    25568    idx_user_consent    INDEX     L   CREATE INDEX idx_user_consent ON public.user_consent USING btree (user_id);
 $   DROP INDEX public.idx_user_consent;
       public              	   adminmweb    false    293            J           1259    25569    idx_user_credential    INDEX     M   CREATE INDEX idx_user_credential ON public.credential USING btree (user_id);
 '   DROP INDEX public.idx_user_credential;
       public              	   adminmweb    false    240                        1259    25570    idx_user_email    INDEX     G   CREATE INDEX idx_user_email ON public.user_entity USING btree (email);
 "   DROP INDEX public.idx_user_email;
       public              	   adminmweb    false    295                       1259    25571    idx_user_group_mapping    INDEX     [   CREATE INDEX idx_user_group_mapping ON public.user_group_membership USING btree (user_id);
 *   DROP INDEX public.idx_user_group_mapping;
       public              	   adminmweb    false    300                       1259    25572    idx_user_reqactions    INDEX     W   CREATE INDEX idx_user_reqactions ON public.user_required_action USING btree (user_id);
 '   DROP INDEX public.idx_user_reqactions;
       public              	   adminmweb    false    301                       1259    25573    idx_user_role_mapping    INDEX     V   CREATE INDEX idx_user_role_mapping ON public.user_role_mapping USING btree (user_id);
 )   DROP INDEX public.idx_user_role_mapping;
       public              	   adminmweb    false    302                       1259    25574    idx_user_service_account    INDEX     q   CREATE INDEX idx_user_service_account ON public.user_entity USING btree (realm_id, service_account_client_link);
 ,   DROP INDEX public.idx_user_service_account;
       public              	   adminmweb    false    295    295            
           1259    25575    idx_usr_fed_map_fed_prv    INDEX     l   CREATE INDEX idx_usr_fed_map_fed_prv ON public.user_federation_mapper USING btree (federation_provider_id);
 +   DROP INDEX public.idx_usr_fed_map_fed_prv;
       public              	   adminmweb    false    297                       1259    25576    idx_usr_fed_map_realm    INDEX     \   CREATE INDEX idx_usr_fed_map_realm ON public.user_federation_mapper USING btree (realm_id);
 )   DROP INDEX public.idx_usr_fed_map_realm;
       public              	   adminmweb    false    297                       1259    25577    idx_usr_fed_prv_realm    INDEX     ^   CREATE INDEX idx_usr_fed_prv_realm ON public.user_federation_provider USING btree (realm_id);
 )   DROP INDEX public.idx_usr_fed_prv_realm;
       public              	   adminmweb    false    299            "           1259    25578    idx_web_orig_client    INDEX     P   CREATE INDEX idx_web_orig_client ON public.web_origins USING btree (client_id);
 '   DROP INDEX public.idx_web_orig_client;
       public              	   adminmweb    false    306            /           2606    25579 1   client_session_auth_status auth_status_constraint    FK CONSTRAINT     �   ALTER TABLE ONLY public.client_session_auth_status
    ADD CONSTRAINT auth_status_constraint FOREIGN KEY (client_session) REFERENCES public.client_session(id);
 [   ALTER TABLE ONLY public.client_session_auth_status DROP CONSTRAINT auth_status_constraint;
       public            	   adminmweb    false    231    232    4401            =           2606    25584 $   identity_provider fk2b4ebc52ae5c3b34    FK CONSTRAINT     �   ALTER TABLE ONLY public.identity_provider
    ADD CONSTRAINT fk2b4ebc52ae5c3b34 FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 N   ALTER TABLE ONLY public.identity_provider DROP CONSTRAINT fk2b4ebc52ae5c3b34;
       public            	   adminmweb    false    4519    256    268            )           2606    25589 $   client_attributes fk3c47c64beacca966    FK CONSTRAINT     �   ALTER TABLE ONLY public.client_attributes
    ADD CONSTRAINT fk3c47c64beacca966 FOREIGN KEY (client_id) REFERENCES public.client(id);
 N   ALTER TABLE ONLY public.client_attributes DROP CONSTRAINT fk3c47c64beacca966;
       public            	   adminmweb    false    4371    223    222            :           2606    25594 %   federated_identity fk404288b92ef007a6    FK CONSTRAINT     �   ALTER TABLE ONLY public.federated_identity
    ADD CONSTRAINT fk404288b92ef007a6 FOREIGN KEY (user_id) REFERENCES public.user_entity(id);
 O   ALTER TABLE ONLY public.federated_identity DROP CONSTRAINT fk404288b92ef007a6;
       public            	   adminmweb    false    4607    252    295            +           2606    25599 ,   client_node_registrations fk4129723ba992f594    FK CONSTRAINT     �   ALTER TABLE ONLY public.client_node_registrations
    ADD CONSTRAINT fk4129723ba992f594 FOREIGN KEY (client_id) REFERENCES public.client(id);
 V   ALTER TABLE ONLY public.client_node_registrations DROP CONSTRAINT fk4129723ba992f594;
       public            	   adminmweb    false    222    4371    226            0           2606    25604 &   client_session_note fk5edfb00ff51c2736    FK CONSTRAINT     �   ALTER TABLE ONLY public.client_session_note
    ADD CONSTRAINT fk5edfb00ff51c2736 FOREIGN KEY (client_session) REFERENCES public.client_session(id);
 P   ALTER TABLE ONLY public.client_session_note DROP CONSTRAINT fk5edfb00ff51c2736;
       public            	   adminmweb    false    233    4401    231            k           2606    25609 $   user_session_note fk5edfb00ff51d3472    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_session_note
    ADD CONSTRAINT fk5edfb00ff51d3472 FOREIGN KEY (user_session) REFERENCES public.user_session(id);
 N   ALTER TABLE ONLY public.user_session_note DROP CONSTRAINT fk5edfb00ff51d3472;
       public            	   adminmweb    false    303    4635    304            2           2606    25614 0   client_session_role fk_11b7sgqw18i532811v7o2dv76    FK CONSTRAINT     �   ALTER TABLE ONLY public.client_session_role
    ADD CONSTRAINT fk_11b7sgqw18i532811v7o2dv76 FOREIGN KEY (client_session) REFERENCES public.client_session(id);
 Z   ALTER TABLE ONLY public.client_session_role DROP CONSTRAINT fk_11b7sgqw18i532811v7o2dv76;
       public            	   adminmweb    false    235    4401    231            M           2606    25619 *   redirect_uris fk_1burs8pb4ouj97h5wuppahv9f    FK CONSTRAINT     �   ALTER TABLE ONLY public.redirect_uris
    ADD CONSTRAINT fk_1burs8pb4ouj97h5wuppahv9f FOREIGN KEY (client_id) REFERENCES public.client(id);
 T   ALTER TABLE ONLY public.redirect_uris DROP CONSTRAINT fk_1burs8pb4ouj97h5wuppahv9f;
       public            	   adminmweb    false    4371    222    277            g           2606    25624 5   user_federation_provider fk_1fj32f6ptolw2qy60cd8n01e8    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_federation_provider
    ADD CONSTRAINT fk_1fj32f6ptolw2qy60cd8n01e8 FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 _   ALTER TABLE ONLY public.user_federation_provider DROP CONSTRAINT fk_1fj32f6ptolw2qy60cd8n01e8;
       public            	   adminmweb    false    4519    268    299            1           2606    25629 7   client_session_prot_mapper fk_33a8sgqw18i532811v7o2dk89    FK CONSTRAINT     �   ALTER TABLE ONLY public.client_session_prot_mapper
    ADD CONSTRAINT fk_33a8sgqw18i532811v7o2dk89 FOREIGN KEY (client_session) REFERENCES public.client_session(id);
 a   ALTER TABLE ONLY public.client_session_prot_mapper DROP CONSTRAINT fk_33a8sgqw18i532811v7o2dk89;
       public            	   adminmweb    false    234    231    4401            J           2606    25634 6   realm_required_credential fk_5hg65lybevavkqfki3kponh9v    FK CONSTRAINT     �   ALTER TABLE ONLY public.realm_required_credential
    ADD CONSTRAINT fk_5hg65lybevavkqfki3kponh9v FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 `   ALTER TABLE ONLY public.realm_required_credential DROP CONSTRAINT fk_5hg65lybevavkqfki3kponh9v;
       public            	   adminmweb    false    4519    268    274            O           2606    25639 /   resource_attribute fk_5hrm2vlf9ql5fu022kqepovbr    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_attribute
    ADD CONSTRAINT fk_5hrm2vlf9ql5fu022kqepovbr FOREIGN KEY (resource_id) REFERENCES public.resource_server_resource(id);
 Y   ALTER TABLE ONLY public.resource_attribute DROP CONSTRAINT fk_5hrm2vlf9ql5fu022kqepovbr;
       public            	   adminmweb    false    4574    280    286            `           2606    25644 +   user_attribute fk_5hrm2vlf9ql5fu043kqepovbr    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_attribute
    ADD CONSTRAINT fk_5hrm2vlf9ql5fu043kqepovbr FOREIGN KEY (user_id) REFERENCES public.user_entity(id);
 U   ALTER TABLE ONLY public.user_attribute DROP CONSTRAINT fk_5hrm2vlf9ql5fu043kqepovbr;
       public            	   adminmweb    false    292    4607    295            i           2606    25649 1   user_required_action fk_6qj3w1jw9cvafhe19bwsiuvmd    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_required_action
    ADD CONSTRAINT fk_6qj3w1jw9cvafhe19bwsiuvmd FOREIGN KEY (user_id) REFERENCES public.user_entity(id);
 [   ALTER TABLE ONLY public.user_required_action DROP CONSTRAINT fk_6qj3w1jw9cvafhe19bwsiuvmd;
       public            	   adminmweb    false    295    301    4607            A           2606    25654 *   keycloak_role fk_6vyqfe4cn4wlq8r6kt5vdsj5c    FK CONSTRAINT     �   ALTER TABLE ONLY public.keycloak_role
    ADD CONSTRAINT fk_6vyqfe4cn4wlq8r6kt5vdsj5c FOREIGN KEY (realm) REFERENCES public.realm(id);
 T   ALTER TABLE ONLY public.keycloak_role DROP CONSTRAINT fk_6vyqfe4cn4wlq8r6kt5vdsj5c;
       public            	   adminmweb    false    4519    261    268            K           2606    25659 .   realm_smtp_config fk_70ej8xdxgxd0b9hh6180irr0o    FK CONSTRAINT     �   ALTER TABLE ONLY public.realm_smtp_config
    ADD CONSTRAINT fk_70ej8xdxgxd0b9hh6180irr0o FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 X   ALTER TABLE ONLY public.realm_smtp_config DROP CONSTRAINT fk_70ej8xdxgxd0b9hh6180irr0o;
       public            	   adminmweb    false    4519    268    275            F           2606    25664 ,   realm_attribute fk_8shxd6l3e9atqukacxgpffptw    FK CONSTRAINT     �   ALTER TABLE ONLY public.realm_attribute
    ADD CONSTRAINT fk_8shxd6l3e9atqukacxgpffptw FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 V   ALTER TABLE ONLY public.realm_attribute DROP CONSTRAINT fk_8shxd6l3e9atqukacxgpffptw;
       public            	   adminmweb    false    269    268    4519            6           2606    25669 +   composite_role fk_a63wvekftu8jo1pnj81e7mce2    FK CONSTRAINT     �   ALTER TABLE ONLY public.composite_role
    ADD CONSTRAINT fk_a63wvekftu8jo1pnj81e7mce2 FOREIGN KEY (composite) REFERENCES public.keycloak_role(id);
 U   ALTER TABLE ONLY public.composite_role DROP CONSTRAINT fk_a63wvekftu8jo1pnj81e7mce2;
       public            	   adminmweb    false    4494    239    261            %           2606    25674 *   authentication_execution fk_auth_exec_flow    FK CONSTRAINT     �   ALTER TABLE ONLY public.authentication_execution
    ADD CONSTRAINT fk_auth_exec_flow FOREIGN KEY (flow_id) REFERENCES public.authentication_flow(id);
 T   ALTER TABLE ONLY public.authentication_execution DROP CONSTRAINT fk_auth_exec_flow;
       public            	   adminmweb    false    218    217    4361            &           2606    25679 +   authentication_execution fk_auth_exec_realm    FK CONSTRAINT     �   ALTER TABLE ONLY public.authentication_execution
    ADD CONSTRAINT fk_auth_exec_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 U   ALTER TABLE ONLY public.authentication_execution DROP CONSTRAINT fk_auth_exec_realm;
       public            	   adminmweb    false    268    217    4519            '           2606    25684 &   authentication_flow fk_auth_flow_realm    FK CONSTRAINT     �   ALTER TABLE ONLY public.authentication_flow
    ADD CONSTRAINT fk_auth_flow_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 P   ALTER TABLE ONLY public.authentication_flow DROP CONSTRAINT fk_auth_flow_realm;
       public            	   adminmweb    false    268    4519    218            (           2606    25689 "   authenticator_config fk_auth_realm    FK CONSTRAINT     �   ALTER TABLE ONLY public.authenticator_config
    ADD CONSTRAINT fk_auth_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 L   ALTER TABLE ONLY public.authenticator_config DROP CONSTRAINT fk_auth_realm;
       public            	   adminmweb    false    4519    219    268            .           2606    25694 +   client_session fk_b4ao2vcvat6ukau74wbwtfqo1    FK CONSTRAINT     �   ALTER TABLE ONLY public.client_session
    ADD CONSTRAINT fk_b4ao2vcvat6ukau74wbwtfqo1 FOREIGN KEY (session_id) REFERENCES public.user_session(id);
 U   ALTER TABLE ONLY public.client_session DROP CONSTRAINT fk_b4ao2vcvat6ukau74wbwtfqo1;
       public            	   adminmweb    false    4635    303    231            j           2606    25699 .   user_role_mapping fk_c4fqv34p1mbylloxang7b1q3l    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_role_mapping
    ADD CONSTRAINT fk_c4fqv34p1mbylloxang7b1q3l FOREIGN KEY (user_id) REFERENCES public.user_entity(id);
 X   ALTER TABLE ONLY public.user_role_mapping DROP CONSTRAINT fk_c4fqv34p1mbylloxang7b1q3l;
       public            	   adminmweb    false    295    4607    302            ,           2606    25704 .   client_scope_attributes fk_cl_scope_attr_scope    FK CONSTRAINT     �   ALTER TABLE ONLY public.client_scope_attributes
    ADD CONSTRAINT fk_cl_scope_attr_scope FOREIGN KEY (scope_id) REFERENCES public.client_scope(id);
 X   ALTER TABLE ONLY public.client_scope_attributes DROP CONSTRAINT fk_cl_scope_attr_scope;
       public            	   adminmweb    false    4386    228    227            -           2606    25709 .   client_scope_role_mapping fk_cl_scope_rm_scope    FK CONSTRAINT     �   ALTER TABLE ONLY public.client_scope_role_mapping
    ADD CONSTRAINT fk_cl_scope_rm_scope FOREIGN KEY (scope_id) REFERENCES public.client_scope(id);
 X   ALTER TABLE ONLY public.client_scope_role_mapping DROP CONSTRAINT fk_cl_scope_rm_scope;
       public            	   adminmweb    false    230    227    4386            3           2606    25714 +   client_user_session_note fk_cl_usr_ses_note    FK CONSTRAINT     �   ALTER TABLE ONLY public.client_user_session_note
    ADD CONSTRAINT fk_cl_usr_ses_note FOREIGN KEY (client_session) REFERENCES public.client_session(id);
 U   ALTER TABLE ONLY public.client_user_session_note DROP CONSTRAINT fk_cl_usr_ses_note;
       public            	   adminmweb    false    236    231    4401            C           2606    25719 #   protocol_mapper fk_cli_scope_mapper    FK CONSTRAINT     �   ALTER TABLE ONLY public.protocol_mapper
    ADD CONSTRAINT fk_cli_scope_mapper FOREIGN KEY (client_scope_id) REFERENCES public.client_scope(id);
 M   ALTER TABLE ONLY public.protocol_mapper DROP CONSTRAINT fk_cli_scope_mapper;
       public            	   adminmweb    false    4386    266    227            *           2606    25724 .   client_initial_access fk_client_init_acc_realm    FK CONSTRAINT     �   ALTER TABLE ONLY public.client_initial_access
    ADD CONSTRAINT fk_client_init_acc_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 X   ALTER TABLE ONLY public.client_initial_access DROP CONSTRAINT fk_client_init_acc_realm;
       public            	   adminmweb    false    268    4519    225            5           2606    25729 $   component_config fk_component_config    FK CONSTRAINT     �   ALTER TABLE ONLY public.component_config
    ADD CONSTRAINT fk_component_config FOREIGN KEY (component_id) REFERENCES public.component(id);
 N   ALTER TABLE ONLY public.component_config DROP CONSTRAINT fk_component_config;
       public            	   adminmweb    false    238    4414    237            4           2606    25734    component fk_component_realm    FK CONSTRAINT     |   ALTER TABLE ONLY public.component
    ADD CONSTRAINT fk_component_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 F   ALTER TABLE ONLY public.component DROP CONSTRAINT fk_component_realm;
       public            	   adminmweb    false    237    4519    268            G           2606    25739 (   realm_default_groups fk_def_groups_realm    FK CONSTRAINT     �   ALTER TABLE ONLY public.realm_default_groups
    ADD CONSTRAINT fk_def_groups_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 R   ALTER TABLE ONLY public.realm_default_groups DROP CONSTRAINT fk_def_groups_realm;
       public            	   adminmweb    false    270    4519    268            f           2606    25744 .   user_federation_mapper_config fk_fedmapper_cfg    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_federation_mapper_config
    ADD CONSTRAINT fk_fedmapper_cfg FOREIGN KEY (user_federation_mapper_id) REFERENCES public.user_federation_mapper(id);
 X   ALTER TABLE ONLY public.user_federation_mapper_config DROP CONSTRAINT fk_fedmapper_cfg;
       public            	   adminmweb    false    4617    298    297            d           2606    25749 ,   user_federation_mapper fk_fedmapperpm_fedprv    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_federation_mapper
    ADD CONSTRAINT fk_fedmapperpm_fedprv FOREIGN KEY (federation_provider_id) REFERENCES public.user_federation_provider(id);
 V   ALTER TABLE ONLY public.user_federation_mapper DROP CONSTRAINT fk_fedmapperpm_fedprv;
       public            	   adminmweb    false    297    4623    299            e           2606    25754 +   user_federation_mapper fk_fedmapperpm_realm    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_federation_mapper
    ADD CONSTRAINT fk_fedmapperpm_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 U   ALTER TABLE ONLY public.user_federation_mapper DROP CONSTRAINT fk_fedmapperpm_realm;
       public            	   adminmweb    false    297    268    4519            #           2606    25759 .   associated_policy fk_frsr5s213xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.associated_policy
    ADD CONSTRAINT fk_frsr5s213xcx4wnkog82ssrfy FOREIGN KEY (associated_policy_id) REFERENCES public.resource_server_policy(id);
 X   ALTER TABLE ONLY public.associated_policy DROP CONSTRAINT fk_frsr5s213xcx4wnkog82ssrfy;
       public            	   adminmweb    false    285    4569    216            ^           2606    25764 )   scope_policy fk_frsrasp13xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.scope_policy
    ADD CONSTRAINT fk_frsrasp13xcx4wnkog82ssrfy FOREIGN KEY (policy_id) REFERENCES public.resource_server_policy(id);
 S   ALTER TABLE ONLY public.scope_policy DROP CONSTRAINT fk_frsrasp13xcx4wnkog82ssrfy;
       public            	   adminmweb    false    4569    285    291            T           2606    25769 8   resource_server_perm_ticket fk_frsrho213xcx4wnkog82sspmt    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_perm_ticket
    ADD CONSTRAINT fk_frsrho213xcx4wnkog82sspmt FOREIGN KEY (resource_server_id) REFERENCES public.resource_server(id);
 b   ALTER TABLE ONLY public.resource_server_perm_ticket DROP CONSTRAINT fk_frsrho213xcx4wnkog82sspmt;
       public            	   adminmweb    false    283    4563    284            Y           2606    25774 5   resource_server_resource fk_frsrho213xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_resource
    ADD CONSTRAINT fk_frsrho213xcx4wnkog82ssrfy FOREIGN KEY (resource_server_id) REFERENCES public.resource_server(id);
 _   ALTER TABLE ONLY public.resource_server_resource DROP CONSTRAINT fk_frsrho213xcx4wnkog82ssrfy;
       public            	   adminmweb    false    4563    286    283            U           2606    25779 8   resource_server_perm_ticket fk_frsrho213xcx4wnkog83sspmt    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_perm_ticket
    ADD CONSTRAINT fk_frsrho213xcx4wnkog83sspmt FOREIGN KEY (resource_id) REFERENCES public.resource_server_resource(id);
 b   ALTER TABLE ONLY public.resource_server_perm_ticket DROP CONSTRAINT fk_frsrho213xcx4wnkog83sspmt;
       public            	   adminmweb    false    284    4574    286            V           2606    25784 8   resource_server_perm_ticket fk_frsrho213xcx4wnkog84sspmt    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_perm_ticket
    ADD CONSTRAINT fk_frsrho213xcx4wnkog84sspmt FOREIGN KEY (scope_id) REFERENCES public.resource_server_scope(id);
 b   ALTER TABLE ONLY public.resource_server_perm_ticket DROP CONSTRAINT fk_frsrho213xcx4wnkog84sspmt;
       public            	   adminmweb    false    4579    284    287            $           2606    25789 .   associated_policy fk_frsrpas14xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.associated_policy
    ADD CONSTRAINT fk_frsrpas14xcx4wnkog82ssrfy FOREIGN KEY (policy_id) REFERENCES public.resource_server_policy(id);
 X   ALTER TABLE ONLY public.associated_policy DROP CONSTRAINT fk_frsrpas14xcx4wnkog82ssrfy;
       public            	   adminmweb    false    285    4569    216            _           2606    25794 )   scope_policy fk_frsrpass3xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.scope_policy
    ADD CONSTRAINT fk_frsrpass3xcx4wnkog82ssrfy FOREIGN KEY (scope_id) REFERENCES public.resource_server_scope(id);
 S   ALTER TABLE ONLY public.scope_policy DROP CONSTRAINT fk_frsrpass3xcx4wnkog82ssrfy;
       public            	   adminmweb    false    4579    287    291            W           2606    25799 8   resource_server_perm_ticket fk_frsrpo2128cx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_perm_ticket
    ADD CONSTRAINT fk_frsrpo2128cx4wnkog82ssrfy FOREIGN KEY (policy_id) REFERENCES public.resource_server_policy(id);
 b   ALTER TABLE ONLY public.resource_server_perm_ticket DROP CONSTRAINT fk_frsrpo2128cx4wnkog82ssrfy;
       public            	   adminmweb    false    285    284    4569            X           2606    25804 3   resource_server_policy fk_frsrpo213xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_policy
    ADD CONSTRAINT fk_frsrpo213xcx4wnkog82ssrfy FOREIGN KEY (resource_server_id) REFERENCES public.resource_server(id);
 ]   ALTER TABLE ONLY public.resource_server_policy DROP CONSTRAINT fk_frsrpo213xcx4wnkog82ssrfy;
       public            	   adminmweb    false    4563    285    283            R           2606    25809 +   resource_scope fk_frsrpos13xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_scope
    ADD CONSTRAINT fk_frsrpos13xcx4wnkog82ssrfy FOREIGN KEY (resource_id) REFERENCES public.resource_server_resource(id);
 U   ALTER TABLE ONLY public.resource_scope DROP CONSTRAINT fk_frsrpos13xcx4wnkog82ssrfy;
       public            	   adminmweb    false    4574    282    286            P           2606    25814 ,   resource_policy fk_frsrpos53xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_policy
    ADD CONSTRAINT fk_frsrpos53xcx4wnkog82ssrfy FOREIGN KEY (resource_id) REFERENCES public.resource_server_resource(id);
 V   ALTER TABLE ONLY public.resource_policy DROP CONSTRAINT fk_frsrpos53xcx4wnkog82ssrfy;
       public            	   adminmweb    false    4574    281    286            Q           2606    25819 ,   resource_policy fk_frsrpp213xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_policy
    ADD CONSTRAINT fk_frsrpp213xcx4wnkog82ssrfy FOREIGN KEY (policy_id) REFERENCES public.resource_server_policy(id);
 V   ALTER TABLE ONLY public.resource_policy DROP CONSTRAINT fk_frsrpp213xcx4wnkog82ssrfy;
       public            	   adminmweb    false    285    4569    281            S           2606    25824 +   resource_scope fk_frsrps213xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_scope
    ADD CONSTRAINT fk_frsrps213xcx4wnkog82ssrfy FOREIGN KEY (scope_id) REFERENCES public.resource_server_scope(id);
 U   ALTER TABLE ONLY public.resource_scope DROP CONSTRAINT fk_frsrps213xcx4wnkog82ssrfy;
       public            	   adminmweb    false    282    4579    287            Z           2606    25829 2   resource_server_scope fk_frsrso213xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_scope
    ADD CONSTRAINT fk_frsrso213xcx4wnkog82ssrfy FOREIGN KEY (resource_server_id) REFERENCES public.resource_server(id);
 \   ALTER TABLE ONLY public.resource_server_scope DROP CONSTRAINT fk_frsrso213xcx4wnkog82ssrfy;
       public            	   adminmweb    false    283    4563    287            7           2606    25834 +   composite_role fk_gr7thllb9lu8q4vqa4524jjy8    FK CONSTRAINT     �   ALTER TABLE ONLY public.composite_role
    ADD CONSTRAINT fk_gr7thllb9lu8q4vqa4524jjy8 FOREIGN KEY (child_role) REFERENCES public.keycloak_role(id);
 U   ALTER TABLE ONLY public.composite_role DROP CONSTRAINT fk_gr7thllb9lu8q4vqa4524jjy8;
       public            	   adminmweb    false    239    4494    261            b           2606    25839 .   user_consent_client_scope fk_grntcsnt_clsc_usc    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_consent_client_scope
    ADD CONSTRAINT fk_grntcsnt_clsc_usc FOREIGN KEY (user_consent_id) REFERENCES public.user_consent(id);
 X   ALTER TABLE ONLY public.user_consent_client_scope DROP CONSTRAINT fk_grntcsnt_clsc_usc;
       public            	   adminmweb    false    293    4599    294            a           2606    25844    user_consent fk_grntcsnt_user    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_consent
    ADD CONSTRAINT fk_grntcsnt_user FOREIGN KEY (user_id) REFERENCES public.user_entity(id);
 G   ALTER TABLE ONLY public.user_consent DROP CONSTRAINT fk_grntcsnt_user;
       public            	   adminmweb    false    295    4607    293            ;           2606    25849 (   group_attribute fk_group_attribute_group    FK CONSTRAINT     �   ALTER TABLE ONLY public.group_attribute
    ADD CONSTRAINT fk_group_attribute_group FOREIGN KEY (group_id) REFERENCES public.keycloak_group(id);
 R   ALTER TABLE ONLY public.group_attribute DROP CONSTRAINT fk_group_attribute_group;
       public            	   adminmweb    false    254    4488    260            <           2606    25854 &   group_role_mapping fk_group_role_group    FK CONSTRAINT     �   ALTER TABLE ONLY public.group_role_mapping
    ADD CONSTRAINT fk_group_role_group FOREIGN KEY (group_id) REFERENCES public.keycloak_group(id);
 P   ALTER TABLE ONLY public.group_role_mapping DROP CONSTRAINT fk_group_role_group;
       public            	   adminmweb    false    255    4488    260            H           2606    25859 6   realm_enabled_event_types fk_h846o4h0w8epx5nwedrf5y69j    FK CONSTRAINT     �   ALTER TABLE ONLY public.realm_enabled_event_types
    ADD CONSTRAINT fk_h846o4h0w8epx5nwedrf5y69j FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 `   ALTER TABLE ONLY public.realm_enabled_event_types DROP CONSTRAINT fk_h846o4h0w8epx5nwedrf5y69j;
       public            	   adminmweb    false    271    4519    268            I           2606    25864 3   realm_events_listeners fk_h846o4h0w8epx5nxev9f5y69j    FK CONSTRAINT     �   ALTER TABLE ONLY public.realm_events_listeners
    ADD CONSTRAINT fk_h846o4h0w8epx5nxev9f5y69j FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 ]   ALTER TABLE ONLY public.realm_events_listeners DROP CONSTRAINT fk_h846o4h0w8epx5nxev9f5y69j;
       public            	   adminmweb    false    272    4519    268            ?           2606    25869 &   identity_provider_mapper fk_idpm_realm    FK CONSTRAINT     �   ALTER TABLE ONLY public.identity_provider_mapper
    ADD CONSTRAINT fk_idpm_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 P   ALTER TABLE ONLY public.identity_provider_mapper DROP CONSTRAINT fk_idpm_realm;
       public            	   adminmweb    false    258    4519    268            @           2606    25874    idp_mapper_config fk_idpmconfig    FK CONSTRAINT     �   ALTER TABLE ONLY public.idp_mapper_config
    ADD CONSTRAINT fk_idpmconfig FOREIGN KEY (idp_mapper_id) REFERENCES public.identity_provider_mapper(id);
 I   ALTER TABLE ONLY public.idp_mapper_config DROP CONSTRAINT fk_idpmconfig;
       public            	   adminmweb    false    259    4483    258            l           2606    25879 (   web_origins fk_lojpho213xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.web_origins
    ADD CONSTRAINT fk_lojpho213xcx4wnkog82ssrfy FOREIGN KEY (client_id) REFERENCES public.client(id);
 R   ALTER TABLE ONLY public.web_origins DROP CONSTRAINT fk_lojpho213xcx4wnkog82ssrfy;
       public            	   adminmweb    false    306    4371    222            ]           2606    25884 *   scope_mapping fk_ouse064plmlr732lxjcn1q5f1    FK CONSTRAINT     �   ALTER TABLE ONLY public.scope_mapping
    ADD CONSTRAINT fk_ouse064plmlr732lxjcn1q5f1 FOREIGN KEY (client_id) REFERENCES public.client(id);
 T   ALTER TABLE ONLY public.scope_mapping DROP CONSTRAINT fk_ouse064plmlr732lxjcn1q5f1;
       public            	   adminmweb    false    290    4371    222            D           2606    25889    protocol_mapper fk_pcm_realm    FK CONSTRAINT     ~   ALTER TABLE ONLY public.protocol_mapper
    ADD CONSTRAINT fk_pcm_realm FOREIGN KEY (client_id) REFERENCES public.client(id);
 F   ALTER TABLE ONLY public.protocol_mapper DROP CONSTRAINT fk_pcm_realm;
       public            	   adminmweb    false    266    4371    222            8           2606    25894 '   credential fk_pfyr0glasqyl0dei3kl69r6v0    FK CONSTRAINT     �   ALTER TABLE ONLY public.credential
    ADD CONSTRAINT fk_pfyr0glasqyl0dei3kl69r6v0 FOREIGN KEY (user_id) REFERENCES public.user_entity(id);
 Q   ALTER TABLE ONLY public.credential DROP CONSTRAINT fk_pfyr0glasqyl0dei3kl69r6v0;
       public            	   adminmweb    false    240    4607    295            E           2606    25899 "   protocol_mapper_config fk_pmconfig    FK CONSTRAINT     �   ALTER TABLE ONLY public.protocol_mapper_config
    ADD CONSTRAINT fk_pmconfig FOREIGN KEY (protocol_mapper_id) REFERENCES public.protocol_mapper(id);
 L   ALTER TABLE ONLY public.protocol_mapper_config DROP CONSTRAINT fk_pmconfig;
       public            	   adminmweb    false    266    267    4513            9           2606    25904 -   default_client_scope fk_r_def_cli_scope_realm    FK CONSTRAINT     �   ALTER TABLE ONLY public.default_client_scope
    ADD CONSTRAINT fk_r_def_cli_scope_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 W   ALTER TABLE ONLY public.default_client_scope DROP CONSTRAINT fk_r_def_cli_scope_realm;
       public            	   adminmweb    false    4519    243    268            N           2606    25909 )   required_action_provider fk_req_act_realm    FK CONSTRAINT     �   ALTER TABLE ONLY public.required_action_provider
    ADD CONSTRAINT fk_req_act_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 S   ALTER TABLE ONLY public.required_action_provider DROP CONSTRAINT fk_req_act_realm;
       public            	   adminmweb    false    4519    279    268            [           2606    25914 %   resource_uris fk_resource_server_uris    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_uris
    ADD CONSTRAINT fk_resource_server_uris FOREIGN KEY (resource_id) REFERENCES public.resource_server_resource(id);
 O   ALTER TABLE ONLY public.resource_uris DROP CONSTRAINT fk_resource_server_uris;
       public            	   adminmweb    false    4574    288    286            \           2606    25919 #   role_attribute fk_role_attribute_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.role_attribute
    ADD CONSTRAINT fk_role_attribute_id FOREIGN KEY (role_id) REFERENCES public.keycloak_role(id);
 M   ALTER TABLE ONLY public.role_attribute DROP CONSTRAINT fk_role_attribute_id;
       public            	   adminmweb    false    261    289    4494            L           2606    25924 2   realm_supported_locales fk_supported_locales_realm    FK CONSTRAINT     �   ALTER TABLE ONLY public.realm_supported_locales
    ADD CONSTRAINT fk_supported_locales_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 \   ALTER TABLE ONLY public.realm_supported_locales DROP CONSTRAINT fk_supported_locales_realm;
       public            	   adminmweb    false    276    268    4519            c           2606    25929 3   user_federation_config fk_t13hpu1j94r2ebpekr39x5eu5    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_federation_config
    ADD CONSTRAINT fk_t13hpu1j94r2ebpekr39x5eu5 FOREIGN KEY (user_federation_provider_id) REFERENCES public.user_federation_provider(id);
 ]   ALTER TABLE ONLY public.user_federation_config DROP CONSTRAINT fk_t13hpu1j94r2ebpekr39x5eu5;
       public            	   adminmweb    false    299    4623    296            h           2606    25934 (   user_group_membership fk_user_group_user    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_group_membership
    ADD CONSTRAINT fk_user_group_user FOREIGN KEY (user_id) REFERENCES public.user_entity(id);
 R   ALTER TABLE ONLY public.user_group_membership DROP CONSTRAINT fk_user_group_user;
       public            	   adminmweb    false    300    295    4607            B           2606    25939 !   policy_config fkdc34197cf864c4e43    FK CONSTRAINT     �   ALTER TABLE ONLY public.policy_config
    ADD CONSTRAINT fkdc34197cf864c4e43 FOREIGN KEY (policy_id) REFERENCES public.resource_server_policy(id);
 K   ALTER TABLE ONLY public.policy_config DROP CONSTRAINT fkdc34197cf864c4e43;
       public            	   adminmweb    false    265    285    4569            >           2606    25944 +   identity_provider_config fkdc4897cf864c4e43    FK CONSTRAINT     �   ALTER TABLE ONLY public.identity_provider_config
    ADD CONSTRAINT fkdc4897cf864c4e43 FOREIGN KEY (identity_provider_id) REFERENCES public.identity_provider(internal_id);
 U   ALTER TABLE ONLY public.identity_provider_config DROP CONSTRAINT fkdc4897cf864c4e43;
       public            	   adminmweb    false    256    257    4476            �      x������ � �      �   G   x����0 ���"B��g�%�{N6M6�lC����J�X����G���@'Md!�0'��ѶΘ|7 �o��      �   �  x��Z]z9|�������%���'�Nbgm%�{�-�[rf��DN���*�@U�E52{r"m8
������c��1ϻ�������?>�q�w���0��5yG��k^���4�:�|G�z��]+:��N��Fnc,�"��x�ݲ���۽�Z��`��$N^J�,���)/P�?=�w�7�����C�.�U
NBO.4���ֈv�ȧ���?����^<��9O��n��_���"�������k������Z�T��қ"H��x�9��E\�/5\���R�2��d9��<#��p����qLV�u������ ��$��>>��>���?�2����r��U�dWi*9/�&|�K��]m#��4��.�3r�hN��0�aD��Kt��Z���\�9��^Z�*�?>����� �(�@���g$�>� ]�O�盺��emG�·��zY,��d���8˝`�ʴ�Lmpw�s:>�֥9�Ě�-�w��t����ȇÐ�|ɻ}蚯\�z7�G���,PB�s��@�2TӇ�����)*��欮#^��)-� ݷb�)���催G��Al�E@q� �$4G��5u�A8�H���p��Q��W]�1�ޕF-i���D<n����AM-��"X.����m�`��å�DC��L	�;��
r%x����pQ7vv��fܘ��+(��`HnP�^HO��4���ObaC����T�B#�4K�g��1������)\ǻ��YQ�9v��#��*�C�^����g) �L��CwP]J)PY(�Ծ�}:짹�ڇ}���pJ���U���f\�_N3���_D���I�9����'�!r�U��(�\5͈����M�/�!#�ӱ��ۃKw�\�ŋ�C�G��դ����w����㳓��^���� �+@�J:YL�1t3���+��|�yO�y-�6�'�]���|���%���$�5"�V
?!RQSh��7J;�vA!'��a�`YBB!p�*�W���(�7EuV�,�a�A6B���%�� %q��GxEu���D�^��#�P����P�p�C��U�F�v!wd�&P�6C���$\[cw���9�r��^�b���j�]�p��*�����t�ba�F���-|�9&4�צ<���a���@βj��4|~ �d�={��Im&(��$�{�H��NV��M7Ԃ�R@��pH�������+l6@{�
���~��#����������"9�����+Y���A�X��_���]������Bb��O�a��Z�j��(�3@�;�
�AA��.7��)y�M[5IC]IL��vj�?A��֤�Ç��s��]�]M�At�5�,��dΪ	��hn�K2L��	U��hjp���x��� �	��"�'E_��yU���{��}A�_*��7@�9H^�����4j+�_�Q�|#����G���9��
��r����3��༖e)N��+	gL#:3�E�a�Q����/�E�ZxcB�LPI�׌��jivb���e��t��2���Z� ���Ka�D������P�d����9ж��_�v�������}�w��� oQ	3#q�sh���]�a�⼐���l'�-f�C�v8=5�f#�����#��l'uȝ<d�xc��D�O�D-�I���m��}�O�u�W���\ʄ	*]	�w��z'K9�vd^S�Us��N��0��φD#"���$��҈�!*#ltKĊF-��1Ҹq�.TOɹ��R̿2�ۅ�r8�b#3�F�i6|�P�Q�9��Z݃����:ջ����m���l�Y�vr�!Sbo�������b�A���n3~��r�Y�����v+(	��c���O��8��	�' �d��LF�n�B�|GF+�i��� *�N�v%�wR��h۹v�6yDV���0B0�0�A��'�).�M�M�j��DwLr?��8�_���m�R�v�������kT�1����(5�قp#����tv�{x�)`��:$��zApԂ+Ũ��
i�;�#W/�lo�c��H�:Y(�A�r�e�P��SiP*zM��ఢ��+н]�����b��m�Q��Lo�䊶�\0�����a:[��������q8���7���[���["�f�}��ϋ�*���w	�/s������d�
1Z����U�F�	�E���e�]�.��(��PB��O�&��n[d?�_�]�r~1ҀrCSO��dC���4��V/[Y�%���=��)��k,+�FB?��}g��E���r1�چh��*ǉo�@9p��4���[��糽V �Ӆ�7*xY�ˮD��XtB9w�^����,���+����ڂ��.{95z�.@�0����lJ��o'�#�ZdȎ��-ѝ��JLO�2�F�?�ƽ�(�kW���V/�)��.Z&Q����v}���Y�q��2$��il6	FӴަ-�c?_������1ϖ�kJK�#0\*��C����kS�[;j Q���S0`���H+y	3|?�~]��BE��=�����Rtl��'P�
�I���C�Y	��
��h婻3,K`d�ߪ�A�kM�R�hY�����k�M�"���e�]x.�4{Uu,V)6�g�i��N�R�?]�����%�W�,�8o~f@GS?h*t�竗ہ�X����aYH8M
�0��2�Q������n�K�	}>Y+��<qPeA�S+@���Q@�KF��#br,ڜT�Bg/��`�qKT���W{*��X�I�gV&J��lR�5�_l6n��l�ʨ�m���N1��p4xI�D����h�._7�f.0PhL��4E�d�rv���>ݣ�=Mu 7��萌�fe���_ֈ]�.�g��3c@�)ֆ8����������l���:>7?=b���6����V�+v]�|��u��J�[~�3�Nό�㌮��Λr�Q�<a�4W��xk�	8�z�fU��ů���ٸ%�sbG''1�<1�bņ�8���id��f㖀�ꭣ_����ګ���>U�j��v�qK(t>��\e��B�]E�Q;�¥�7��}j"�9�3e�!.�p��8'V_����� sa$d�C���V���r(��[�=w�@w�F������[�H���u��݉qk풭�BcZ��  �M�jfM�=nK[�^��8��>/[̠��_��5�0���}�ײTF��fr}��^�I�0�+��ƴ�9�˴?ظa��{�?���:�V�����x��˘�3,G��^�+(Dn
�$Ux�17��4ւ��i��1�c�lɢ���_n6����.�V�L芦u�ҁ��<�8���U)��iڐ��@�Ն�f�����q3���:+���M��`�!Ҡ�Fy
�l6���{�\�D��`������O6���3��$^�=v"8E�=%�c��E}�֞t��3ϥml�<��畇є����A[d����Wz)�_�r��s9�#��f�j����2����#�nH�����Zd��h��@A�FDm��ɇ�z�=X�!td,��u0'��~ݹ�t>�&��B7m'D�
��;�g������pʵ̙MY9�j�B�$�B�z��E�5I��fc_O�·&�S��5�"������K���&ǲ�����,4�E6�G�G�ɧ��l6��^o�iD�آ��b��z�����������?�.K�      �   x  x��X�r�}}>@�q�<ʦ���e:�S^h���r��������ґ(W��H.=q�N��>�N�j�)���+�2���3s�[=��t�o����о�����m��<N�!ao�\��VI���Y��ƺ�}l�q��Xe�Lw�<�/�7ަ@��(��8�ٴ��3��������-]������i�/�4��2�^ՂG6�z6�0�Jf�,�9��$�wZ��mW���e��D�?L[���F����[�G̓�6����mb����q/v�_����a���o��UL1%[�$]�Y���Y��S����8���bG�y��mߝ-���y�O��
�w[��/�=k"kt�|�`,KW��T��)�Z���ΎH�|#��X#�!�45�{�
)�rڴa�.���;���qx��:^�t�M�C�`�K�*]K��((�V�t���;��E+}1��$����}4��l��I�6�
��i����@�vɇc��i^>���3U`�~�n�帽XE�lr�^��Q�� 9�*kA%����	�3u���n7,J��v�_�_�Ϝ����w�oΖϸ[m�jK']2�"K	x�j��{��NQ5��P7#��ߣ�>�����?	�q�tI7�dhB�%ˢz�Q�)O9+c�>���@��BH7�Ÿ^������muP(>�&�F���^���u�:�n���r��K�\qn7��
�Zi{/����f���V���W!"��.]�kC�%zM���t:��E�GZ��d��A%���i����V>|9*�6�҉��C{b(iAQ�֫,9��J&yi�N��-���k�&�<����i������][����cX�h��]Ӹ����Eq�O4�P|�U����KeY�FqIdRLK�(hP�<�n#>���$>��6��:1��Q6���>��j�,09��F��Q����=�e�3���-��?�(�h��Q�9o�Rv�_*\I)M�;�&��--��u��m7���S��h�=s>�[��*�ej��u�T�f(t#Z�~y���śދ������O9}���Z``�xD٤%�����᠌�Zx�W'#��	^}v\;��C��(k]и��xw�~��RK)A|�"�6GI��-��Y��8<̓;v�`-��=T�L��U*�k��p����)R�3�B�f�W�J�M�=����s0�l�c�e�p%Ne-��	�L3U��=��_�R��S�F'tY朻d�sU�$���=��HFW�պH1�8�X�@D��F�U--����kt�j�?wT\��b�ʅn��/�y�5|��.C��7J�T�4�	�SO��O:�S�٤�$B�6%�z�
g�_Ӄ�����*F<��-L�������VSO��,�Ffd���=Z|W�x�4#+�����jʓ=�� <���BJY/վ1�_��P��*�oɃ��uL�s��5jPa�����>̵O�/��Wi�����^W8)d^	��!mD1��mx�U]�g>����e�	�7���3j��|Lh��xk��!*�SR����x�:���
|�`zw�o����Q0U:���r��:6��x�U���:�܁kѠ�->!���gm6��|UQD�#�.F�x�ũ��jp�T�%<�l�|��ŋ� P�-�          �   x���KN1C�ӧ�J�J�¦R����43p}r����m�ё��lL`��Y���Q6Mx9�������5v�]��r�Sf��A�pR��	�{�Q�RdF�
�Ԁ;"�K����~�3���z�?�|���9q�,�L��-�КK+�x�>�`�3���3N�VR�C4Y�[_[��D�s�=��5�Z�"�ˇ?u<?m���n�         �   x���Kn�  �ur#��w�n�#�4y�<��͢h/0r�yd�@,���Ң�%Y�|�9��/�W�[�k\�1�i��y������T\�11��=p0+q���l��1e����x��k4�+��2̐��{�ݯsM�Y�耂�@55(�|[�.�����cp{"��z M�P�B-Y�b�~�u] Kh3            x������ � �         Z  x��VێE}�~y�u_�o��\�&�H�������+{�����Ԍ�,���]�h���Ω��n���!�� =!D$�Րs
*����6Yк���拉��W/��~m�kY�.X�BRd�X��.\�`9������W������\V�o����v��s��F��H���*�4r�Fc*ey���A5����h���t�D��[�fʲ��[���n��u��ó�t׿��5������ӚM�U��]���%���j������9��v��/�PSK��0T��T�
*m�h�W�^=���3ظ>~�\]-���b$ɤ$`k4M��ю���n5���b��d\ݕd�yΒ|8�?U����1����xy�� 5���d�ж7���2���<��_;�G
4$6���T�����	@V��٩��5��@��|&yO��Sp1H�`�F��*i-TRnDM��#2XPG���$V��X��R#:�|��3�EQ$��AN�P��l-Ԍ��X���`4��X����*�:Р3Py���"��V�&�$� z�R�hU6^�I��߲z��z8�̠��)�$�`��1]�>�qe=����Foˍ]��Xi1�~��j�E֢�G(�P�}]=���<J�N,��"`M�c�$N�fRXt��������U�)Ż"����%ՐL,u�~����,�]����e�����/~��z}�?�s�����ﮯ���y��'����ө\��9m.;��vI��r���S� ��
x�����X�+*7��]Q�)䘋<��)Ӧ��ذ��ƥ�S�2�����⬏�?��o�@��4�W�e׿�ޏ�_]^\\�
��@         �  x���˒� E��$���od�M�46eYr$<����[3�*X���`�fk�a�H�L0����%�P�˼6>·���B�.��_���w���l�q�آY$���U�Z
�� 8!q�s_�0�4����<|U�킱�F)� Q��bd*砊$���k���£ALZ����a��!N2%C �;���Ð=ibʃb�e�Ab�+2Z$�<�`��V�����n�%��~ݵ�xd!���Ef��,X� �0��JS�+�B��Z�'���AI+��f����^j7�m���<,�?C���P`\i#�f�X|� O=�i��_�+��Mk��מ|�r�8m���D|.e���7���P
	����D��L��b2�R��]��������&���>J���r]/#��n����ro1M�)�S o��ck�/����J�O��Z^9\.�O�Ƽ_ߦ���eu�            x������ � �            x������ � �            x������ � �         U  x���M��D��ί��������� ����XC�9?�J&�Z��R��1������}��c�A��;���^�`�K�&�"��f~�D|8E�4�	b����A·fcf�^�_�y����e���c{��G���@�=;^I�y�@Oo�`��10�!Q�⻃}��>�ú���~:o3��w�~Ok����wY�%��B �Фz�6ڢ&0�6ܯ�L{����ZW��Z��{��m]@�o����x$�d�;����xR����U4Q �\ ����% &�nQ[2`��V#�u�{�B���9��ԇ�H2���R��y�����<��� p���
K�Pjm��9������GY�SƇ���<��e<~��)��o�?�\�����
!֝��(Kg��#7X���i�� ���#�QUǋ�-NMGG"l W�%�ň�|4������
����,��d��O��v��k/��zu��E��jS����
�? �[T���+|���ǉ�8-�6���q�=j�V^y&����/֏Zʅ�.���(�
�����il��h]�-l42��)Hj"0�E�c6X��Ь$(�u��;!�6.���9����'h���Kh6��V���4x���밣��}஢Ѽű��f�N(�F���HG���Dl���-\����m/>ktR�̷Ƞ\h&R��zJ��[���}����*���*�%A�E�%��͛t�%4'��5'0F5CV�ԫR�bRM��8���5ނf���A�bsUk�#�d�Z�C����o7�J4'q��m`#��YM4���9��7Jh�s4�d���\.5+�������0ר7~#g4oP�����7���_~p�      	     x���;�G��ߡ��<8��p�*q��!a��҅Vb���4�wGF������F�5Cjq ��A�RD����ܮ��e��}?\���9�_E�;�a�����,�eY��˛|���$�~��z����P>�V 3W�qh)�B�ٓ��n���/�z��r�?��mN\Q���Agj�����'_���s�7���߮=����u<��ې��޼|����vIC��^˃���P����c�H�fOL1�wy��i��yU+e
�\R(�T���!�Ԇ'듭���;�q�n�y]+���d'Kb�`���|���6�d�a���r�l�yU+eUM�lrAe�(M1BmY��C,�m�5��߯6���5ET:-��EEZ��.�y���ݶ���/�ޙ������W
p��&��f05T�bO�$��2o0y�=�w>�����%h���l�0��qS���s�l�P= V�d�^�`0�Om�K���fE��#:P�
��Qrm�q����c�-F���(Т�#E)1����b<��VzBՇ@5���#���#������y�S��t^՚q?j,6���s�$`��]����is/�a<��V
�ctr�������j!5�(U�g�\67�)�S:�j���M���3�b&_�6&[�s˕���=n��T�N��s��fվ4#�AвC#�@��w7�?3�{�����'�w�I�\��_�!���V�e��)�{����V,�D��� � ��d+Zg�MO@Vd|>�v���Ɣ�      
   x  x����q�@ߒ/��}�����XЃ�JI��)J��mm��f��b9O�/���[3���9=�>�D�_پ����n�������ռ잃����ƇZͲT��j�t���S.w��<�&k�!����Ѵ����{kJ*f�#Y~�hj����GYӛ�܋�e]�>�V��{�f��'�*V��2�EMLK�c1ٺ���g�t��&YO��l&Sg��[��kK�P��ֳz���}�$�-/~]���u��c�D�ćJܣ�$Ǉ奻�2�r���k�Uc�ͫ�זt[��Us���X�UĂ������]E,�*bAW��X��b���[���Q�Xk�rG��Ă}O�*bAW���b�"t����]E,�*bAW�wy\��n���b�=)��8�\�u����]es1W��X�UĂ�"t�hhq,5�_��qw�?>��ǝp ,��v 4� �E; a�@X�� �EsU�=��=�>��e�������=+�U¢�JX4W�\0W	��*a�\%,���Es������9�V�[#��]��YJ�3����\��/s��W�2{9q�gV�m��{��<zu��J�5B�i�j�x_}���)+im�ϫ�&h�C������Z�]��Ns������cb%��m���)�+��xr�X_�ī��I�[�Ȗ�ӡ�v�u�P}�3�[D�u���Y��ۻ�s�^�kyKn/��c�i)L��91�;����R-�}�'��Ȝ7�":��s�����c���\:�Զi�}=-�F��`�����ʰ�Zhh;n�<�i�����X�UĂ�"t΅\E,�*�=r���l��U�����A=��4~,����-�1���s����]E,�*���X�U�{�*bAW��a����'�~���1���x���x��U¢�JX4W�\,W	��*�=�U¢��v�\m�]<�rF��]R��~��^ag�xo��*aѾJX����l.�W	��U�{�W	��U�{�Ᵹ��Ud���ܿ.�W�˧G]E,�*bAW�
�B�"t���X�U�{�j}�W9��sAJC�딘<��e��s����E]%,�*���JX�U�{�*aQW��ֹ,���yw��Wr.-�Z#۠�"t����]�s!W�
w�\E,�*�=s������NO�         q   x����0�����L���_�Z��'����N��KT;orM���c�,�<����'r��zH�����E=A�cu̶���d��jNO����F=�f.�w���c�?t7(             x������ � �            x������ � �            x������ � �            x������ � �            x������ � �            x������ � �           x��W�n[G]K_��0�kY�(
�)�4�l8�-D�Uu�4��RV_R����a����q�g�C���w� �:TS$_7�K�}�ߍi���0�r����7�&!C��jC��g��	�>����'���@����?�X�%�W�=��f5�tX��nX��~������}y��aZl����p7�m�
�0.`�J4�|Ͳugo�����嗻�^ڴ |���V/��4�b�����c=^4tH�3�;�[�?�ŷ���z*��h�b�Ĺ���b`�V����)V�3����eq
8.~\mV�iQ6�N^��>:��	��;`��G]�a2���-u�}�^���{���[��d��p�����N.`���<�x9�dr,l��O�oju�W�҉��?�����{%�8�f����`�1���-0� �i����~M��;ܪ�����}I5כ�j�v9�<Xcz�ܛy�>��TR�H�BAdH6Gʦ���l?��V�G�iQ�M��?���W�|^5�Os��3�H���ItN��!B0�}�-�b�!�l���{n�49c�.F�����AL�*��a�c�!Z��톮N���i�����x�W���E�ٓtS�Ɍd�6�s����T*�����8�Ё����٪�P|�)^����уAɎNY����ZH��%��=�I5׮�T��`23`� *�S���`����󽆹Ss�V���C*��X�~���(���_�p�齃;5ۂ��m*�K�� ^�X�ñI�-���tA�I��a��\�6o�h�U���\�V�Rͭ��j��f&�~�mf�=����G�>�v��|�D�������k�z������+1z4�݈���:0)51U�����̤8O��\��jӅF"pG��Ԣ��&F�T&Ǚ�f&Ey�m����X}�zt�m��\T�אc4H�?4Ϯq�n�2�⵰:�1t��D�?�:�зW~>}{%`�NS%[�hU��P��C@��\�_U�τ}v��k�e�Urt�Gݡz�T�щ��}��r>����aF            x���ٲ�8�-��+2^�����A�Qv��8�� JQ��_(��vUf����8�mK[�;�����(*g
.�h��1�byL�I�ʼb �u�� ,E����������&�oD��[q5�#����qz,��qÆ|�-��s>ܰuF��e��b]��>���yU� ���MV�S5��]�,dK�V�G[���0<*x�~�m��� 8^�%2�����Q`ʲ��� I��H��F^U���߶�3tYј@QF,V`Z
�਒�K�������3�P�9 1� ����Z�@^A�)T�/����Z�1o���!6�����<˰<�0@�h �b��cEIA�������"1=n����w�D�ah�bj��%1� (�.���:/�_�Jſ�DY,s+)�D������%�S\E�,K�2?��v����_IA�)
�
\�,���
V@�IYR?r�g��@� �B�T$V�ZP� �H���:V���m����5�L+���0�*hx�"�/	����!�fX��HQ���<���Ǡ/���?�����ޗ�E��eY��W
F�bW�\���\UB�(?��fh�0�P�Y��x�.0�*r�쀁L�?G4�	9�heX�D$!�
�c1d��K4o!��.g�!s����DA�^���hm��Pѿ̃��BT0%�x��B�%�a�PSYK�_a�ߕ��J`K�@��Δ�BJ��y��$�������_�����f0A�z) �	E�^�Ð�@�����sgA�VШxi�F��T�$Y0����e���$U� - _2��QB�9�*��*yQ3�/��/���5-�t� �@�� ܩk����a�����P�+x"Ǩ�Bd�A�[_XcH��*��/-��:gV<���XT|eU�� 9�ޑP�,0@A��5V�;(���@Y
܏�Ji����_�	^QeM��>���s��:[/��l�f[M"�fQ�}�`�qA�����I�uj�X!���y�êB���r�I!gS,����LY�9V��֕�b1(�ɳ9O $���Ծ�����l�(�(�d�S�)�Ŕ��J��=���{}m�G8�uV��s҇V�V�"u�^��8���rH��22Y��`�&}zq�uT���WWS�#�ǳ;���U/!р�,�zy����lL����UC�*�s�.��oڼ���I;�f?I��k�Đ��[~����P1V <NWa�T��k��IUJ~*{ah-�Y/���oX�V���u�H�B��]��;'EgP���2+{�����]���絧gv:V�w���XD�+w�{��=;kL�x3�|���d�ad���艒�@q�u)~+Y�s�Z�/�� u�|j��(���s��:�D�- �|&R��S�V}��J'b�1Z*s�xú�ؾ��;�$���wsY焺�L65��8��$��8B'��9�	����M����2uYw����L����͌4�8�-w�!.�����]���}&<�L��%��}^��r�O�Ve:���Wr,��m�,+�2�1��z�'�N���_o�qbֆ����*�)�|(h��AG�\Ὡgg8���]U�:5!g�|�T��n���\:���L��Ra�L��h�Um ��^���*`[f8�/�V�ّJ��)ʃ��gy�������Ψcu�=�f�U�-�Ys�o�#l���:l�����.�{�8>�Å��ξk�
7U��4lץf��w�%�s���G�5��>�s��9'b�N>�~ь8��;�\���\�b>~v��(��j�`0���D[�Gy�0��wm��g��~ͪ׳">W�Hl�^�5�q�7���	�Fy;�gJ���5��eڽWߗ��0=j����>/�%��{_���x(c�����/\O��z��}�U�|s�[�4,���xI��T/G�"�UF#p���}�'?ϴ��}`���k]0W<�377�g�����K�L�4>�cALK\T53�F��H.ڇ6�W��v�K�O�������J���r%���=q����Wǁ��,Mm�Υ��|̂e��&��l�?S{�����0�lEKA�o�@���sY����cG&���y�6����-~��#�]/��5��ϧ��˗x�;5}�wx��2�`�x'���cL][#�����eI��n��q"6�3���p�~���xv�(��f�S�5K�WX	�H謿�ys����fs�UJ�\� =�wC+�f)�����L����}����x�u�{�z�z�u�Z�E���U��,���oTQ�<I�Έ/�E�(��J$A���i�'�Q�h�?C����0�!: AI��Y��
�lE�\Y0?��S��?y������A<�9�+) K�ΑX���["b��m���u��G���,KW- �#�w�-]�gӷ�����GQ���o��)��)�xY��&8ozS���{��>+*q�O�}���}�O���Ǹ^��,�<��(���n$��!)����������E��mW+/_<T�LXu��͛/�̍B��^saE��4R�e�w47W��������"�+s[@�qn\X܎�v�-M8�n�ÇE�Ֆ��}���vZA�)Q�-�;����=����0�����ΐ��+ηn���y����Ţ�O�zs�ae�C�`;KS��+��D_����&7Z#\2� �JRsj�j������F ��-e#��?��8
b�-\I�)�R�%�9e��M�6�I��v�*
���K��zm�Sǉ�3�O�wm���b4��FTʒ<QA��D��vĽ��nk�Y����l�h�<��Zw��罟��?��@Z$5FO���=j�`��aq��Rw� (�;�G�!3���eI�����{l�b��U��zx�����v��la��e�rSx���V�H��R�K}lq�ֆH���{�|
��	�%^d%r��{l���{Y�J�.�+\i�:�M06�p�p+�+�.�FSWT�O� ��F��ʹ2ߔ�x4����&-�����7 n}�j+�YǶ+����h�ef��i�5~����FT%���C��Fң� ��U�-���~P@D	�:��mV)�Qg�.A�W,/������o� _�V�$�<�"��Y���<�jX1<��A�VL���
��
�aE�d�Q�7�va�J�&/��!YbqA��av��$�D���A;?=Iz�z���G)��.��?������F�%ʐ��Y��po���!�����+��@7��1���~������f^��'�z�eM;���{O<ݚ��B���JzZ_�ؙ_�I��7��T4i�U���.G�4W�5�B1<�����k4����Æ�w}W��΃���$|2�N�6Q��[��ޱhr'	խ<_i�h�-9d��o� 4���gQ�ʅӿǊc����H���g>�#�S^�S9hK����j���
��̰�cMe�G��^�����L=�3 i]͓�0�Hgc�O��
~�NiIl�h����fwE��/�t�&et���U�-=삼l�G�t�U}V�k.l�-�ĝ�h/?�25�	D'�x�]OfX��νoF���}������dV)����ޘ~|�o;�Z*|��iRu���m�{7��$I}XZ��60k��x�Ë�Ɔ;�ᲂ���g�A}��M/|^;Z�Z���㷜-ْ�+����xL A�QU�H���*~������,����#���� ��
I
V���,W��Ee����e~�(�������So����]6��悕3^Rn+�BKƮ"Q�.RU�ǣ@��q3?�Ͻ�|��ܷ6�^��q}~�F0�P�?��ݨ����ZQ�J$F-���6nP��\w>�A��ɨ�<fi����3��zt$. ��:�?W�R�N�u�8��ф��䷓��O���u���G��b�����x>�{d��b�����U�}����m6�$j�/�Z*kG�e��p�F�q��������s�b]gA�1jq��0�������C�q�Iʕ��_�q�$e];n:K��_�>7~���]K)��    H���|��^]���U��${��nޮ���MVǺ���w{�`߱o1|z��?.w?�̏�Fr2P����)d0_ߓ~�C+���8'�Tu`�k�Z��&��'��������"�E�Ǳٴ/�5�U3I��t�?��'@����GeW'��cDBo؄�z��o��2�T�:���3n�P��S� >�~�d3�?��VM[#�sʬ����W���D>?��ʑ�XN��Gs�=�c�D{ \�Hf�L��{��Ŵ?S:SO��MŒz��,_�;1��K;��7�__���7�`��}?�uW��-u7��=}Z��j�s7�x��Ǜ��n^˯e��XY���Gg�#s�J͉��P�Ks:'S��9s&I$b|�0>E�Sˌ�Le��W��ϱy*���pk�d�ri�&s7x����-���d�ڦ1��Q�6�'OG���R&�O��8P�m����e�O�����ķ������t=q��=����n_e.R3��sye.ծ���b�[\��w�ܭ����t֚�)����=���+anZf�'���H��0�o��TJ_�u�� �f,����W7��[�\9|��>|ܥW��SdW�wӉ��q{�Ϣ<�G=d��J��82����#��e�{�ˡ��ok��0Y �ks�t9��i������=��syKu��<�QJ�p.ş��6r�S:F{����ж���=�OW�$O����]?\r՛t��:f/�S�&�H�~%�����f\��|�B'���-�z��H��zn%wdI7�Ƕ���3���\y#\o�q1dձ���:x~up�h�5��̞���\����p��<�`��H}L���%�	9�����x��@s�Y�9�����hO�2�i��X��H�r\�	9"�%�Ե @�?I��ID#
+	~XЈm����Q�����j���P9�rAb�w0��8L�X#��&���Ӱ��5I�H��Js5�	�+a��LIrx�����G��) �A�D�")���e͠�ϰt��0�P�h��Y]R5�Qb<�gaY�~���	.?8��kՃz_x�Z6��7��JV� �*bt�|�_ �<"K48M�5��e)
[!�@X��y! �>0,��L��4z�`�{"L�H��tM!.ñ��h���߄�qY~ϡ�/�A���]��y19$���9��Es�bX�qȜ,	���b��xZ�`* 	�Y�����`Q�]V�`�nmY�{����HU�����N�_��qir��������
��] {��r�,��A{=�~+��
ť K��h�hqI�"煜'��9?�)M�![�0���B�%�`LY��EPE�܏�"� 5F�h	h�\�h�H&�����(�c�/���� �D�޿k�H)�^�X�l#�'78��Q���ͷs&ϕ���3S�z���0H}�����괳-D#7V� �^���f�9����-�g�˦�ӻ-/N����S�Eѯ����� �e=����(���'ɜ߇�i�xxȃ����N�E��ii��G��Cc��(��y��y�׫�d�V�P�:������aT4�4�	��m���4��T�f��B���i<B�#���!]<�q~*`n+_J�Y�/��J��|���m2k��l3t��x�n�0: �n@�-�M.��ổ�vTk5��WNb�Hc�>���br1���-��^�f�Nndϟ��M���W�ǯ眳�	,�
��#�('� �������%b���alԧ�1�X�9���:m~����L��}�s�..�F1	�\���Ë}�'qRĒ�@߅��D����ƣCQƽ����S�؋�]6A){��v9Ws�S福�1�oG]a�ۙ�S��C�f��͵���h�5%H&1i�I�zU�6?�]ng��8c�u�%�b�\�cu��q8��I���=2�ޮ>1�t�^"=O|�*�I8J��~�u�_���3j������$?_��sg��,=���{J3#��:��&�����''�URi.&w<^^� �
J�m\WpaX��{-&Hq��A}�E�uI�����:��{����t%�����[�tl�>T\w���cfZFL};�zu8D�� ϛ�t�ݧ��J�S*��Į�b����C���z�b��eK�7v��C˝��xѝM�2ơ�v����<k�Q���d�p7�e2�j{������x�wC��[w���P�)��#����*���&qh�QN:���p����;/��{%_�8j-����4-�.15�_��aj��%�jJޓd��Wչt;>/�cD�q>�R��%%d7
�fla%�H��rx��;�=M
���_"<m[�O���1�ܨ^��7�H���"Γ*��+��v�虞��'J���]f|��'U��G���)�q��8���S�^k��㛺-L��	Q~dW���!����`�½3M��������6�����;s�����J(h�]~|\�?Z\�7t�����`_A�^f��2{�������J��\��������L&r0%���^8R�Ύ�#`��v����M��&N����/r�[�Vep^��$�h��L_�Ie`oT�h	sL�
���o�@�(���5b<D]�(�b�V���T'��]OA rB x����u��}���ٲ�n�?�z޾��)�Ǯ���ߟ��g�����;��RQq{��T	������9�����w���z��)�>��&��*n�Z��-�����n����6WT�߽�������"�O����s�	��X6]\�]/�P�ϔ�}�<��Q���>?�ݙ�_�òw�^LI��`^/�v�l���z�p�ϰA�7�P֏�}܌:qlo�a�ً�W�VX-�1�G>*1\����2{��-(��x�ۯ���jꓼھt���˛���}�s�� 	j���4�4�r���1'>����qq���<��sHj$�4E�l�'u3�@��y�"婜��>\��.&{�r���;�����*1�QQ T_��M��n�[t~�<:��1�?l�:Ga2�p�y�o���%�J0��UV��m�4�:Q%��n���zkQ�^�P��.�ӱ`ryԞ��G�{݊��'�oY�^s3;��r�82<bv'Kew�$6�0oH"�����<��Y\8�^ǋpJ�3��X|S�[��C(��P���)��j����bPى�A�/<�g��|쥜~R��U�e�Y��9�:���Ns(.O����۴�Ż�<�W����ۜ�[̐�Y�5/ i�!�P�G�+j�"���(��#/��H�"�|�l��b���YQ^ !��\	��ĉ�fǓ�����F�9�6�}İ�0@�u) >]��O���bٰ�(k5j 0���gx���ypeA�?X���'|�m	�ڡhc��Bd<GD_��|���k�y$S�,�I4r�!1EB��x��x��F��|��y��o/�8 �\;�n��GX�v��6k(Ӟ?��M���Q�ӡ�ak�؂
�gp�T����+ܣ��o��[X���r���A=�Dʤ*�fd$ y������jF��ȼ`�2�w͎D,G�X�����0

�9�'�����H��L�t>��(P
?g�� K3u�{b�ՇH�_c췥�u��%���5�@�
���A��5�(o
�����R�E�ߵ�3�ז���߷w4��^i�O/jߥbW��h~�޻?�k9+��v�{�;�Ar���V8��'$��x���Hķ��Ǉ):����B��[�k�Bn��.�ٮk���UG������?��vV��x��Aɼō�K{���0e����~4]�Ywfh��녷�忯�@=9p�����<q�����d�mS�ջPG�����>z��My�#
BܜB�Ty��W.֐�'k_�G��2sL&�OFu�UA���!0Rs�?�hk�|��۸�&5<(3�8�V�G��߶���
+��2��E�(G�k�z��o"��Y���"+�7|���NO���EQt�G��#�2�y��eV�x�猢]�3�IX5'�A3Tu�L�x�4���ޙCtM��;Uz4Qh��~%����s��t���P�ؽ�/v�L�kWqz�Ȥ� p	  ��g�IG��D��B�$��Uߜ�J�Z�1x���6.*�6�{ճ��쌟<��MƤzD�-�%ҩ��z��d�>��	:=��}Z���f��kC7U�--ŝ��6b�˱{�7��dC-�@���B�/���c�Ŕ����IE��s%�OH�|��D��Q��˱�Ë́Fx�%Â���a��Q"�E�H���~�" ���4
K��O�/6l};�E�]�_�>J���8�\M�S�����k-�o���4��|�\rI��ef��Bf"$E�c�t��h���]�H���~&j��jF��x}�%>g(&+��������d뒄�!���D:OvP�������`��x����V<�]k5;?�����(HNR.�&� �^P�<׈������c\�K���{`�{Am����z�#�"p�Ȑ�Dψ̒���o�N��=^'Zk��f�q��&��P���'�hʡg��;��Tm��^���zwQ�'t�9���a#Y���v����2 �t��P/��j��;_�?H��J�<�'�t��a%�SL&�
�{Rx�dl�G��u����8m�2o��(��xN[Ȇ�*�ӓq&�:��ý���\��E�)�օ�$εTQv�݈[�q���+�b�ʸ�/�Cj]��x~�}L?%Kl��(nu���5�����s1��9�v���|{�R��hG�o�:y�\�}�k���,��ʓ����sH�||�'GV�C;�c�+������7���]j���k��=^� 8y_;8��7��{ٮ��)n��uu���JP�pg�үo'g��Ip���wܤ0�8{�1"�b�8{%�����UήU�7<���7�x�uD�Y�����m'S��H������XW�����Խ3>C�.Q�t� �uy�w��R���ʰA�n�P���ڒ�jqv6L�ɹhכ�g����V�x���{�����<K�O���i��R�C)R� ��sNO���[�u�{{p9�Z�.�V-k9L�*P��晊*�g$��>���l̠S�3�$�:�|�++�:w�3D���էzO/M֊�z�ƻ��Ǎ��5O5y8�8��|���&h��y���t�H�l��G5_c���Ơ|0F2sc=�>[ XET���8I�E>ͨ�A�1�Ǜ]�T����_��� �xS~�U��S�N/�����E�ׁ��7�VH�|@�ce�'�IodҤ�����nxw�>U�o3�o�+0�=�he�XT1��i��g�-o��ѽ����s�x��Um ������qc/ck/o}:{�l28nY�CCb��M�'<�<\��[`�a��z�ݷ7㒧�ޫ��Zh+���ꇠ�Z�J<�:�z ��&�q=��n�Gr�um�AR�(M�Jqe�;��@�tr~�x�i��PP[g���=%1H�A�'�ќ�Y�n/�g��p��\��m<j�F a�D���J4D�)D��.k�*�R�Q��{A�Bl��[�� ��]�Gj��+���<ZP9��<��Q�yQ�ܰS4!u�Lo��J��������� C|��4EVM~T(��H��xH��˟��U$,�`u�|�Ą�{+��޲��1R�H�P�{k�`� *�.��"B�>YQ0/ˀ��~e�� ��)�"a��*6G�E���*d�_�bȺ&��A�*�WÐPFm�
�����D�$h�`�ki����Ky�W�PW�?�/D��'y��
�41M����W'�9J��4��?e�_��H��[�`d�o] �I�u���y�@��?�YE�{��B`a� ��9�S%_��g���@j���KUE#
��"��$9��h	��%)�FsB�Q�� Q��ó,�l�?��	�r4���{�͡a���up '9���.��ZaU����P(`E]S�#�\�P@�y��;�x�(1��f?]}/��ZaTE(04U�����;�9M�(9�$��}��2�PC�G�U �����_�� T�,˓�ZD�+���d����5�������H������Q2�u�'Q%��_f�_���J0WbP�	���R8��\�sBYÊ�̏?�tE#R Br���V߻���b9)�B��2��y�dI��5r�-H�eN�4���1"9�q�}�����
ܰ����v� �(��CJ������ ������E�pES����H!_M�>�3lY	�*J�Wx�o�
ү��vO{�W�"��(�C�ԇ�̍?-4'TlUC� �A�Fq(��_9��5��`�v�:$�˲� ����Q�Ø\ ��5�R�ׯ�_�P��kc ��rDf�{ �t�c��+�_�ǿ�{�	4��� !���\W�P�c8��IC5�_��_�а�(�� [Ce�	�y��Q1�@�%�_�������o���S         A  x��YK�%1��݋�����&Ɵ�/���f�&y2+#6I�:|ƚ{6g�M����]mK����w���jl��i*뵴~�fq����N	�r��f�ٔ��u����K,C׫!%�7G�����n-G�f}[�[��Ԑb����%<d�!79�0���!wɱ_۱����<h�g[��VC:�s�u������M�8T�'��"��7�I����:q;�ۼ{��o�����۱;��-$^~מK��^E�o��L�����$�=��r�x��B]|�s�"G#�-;�Q�,�nd�>��]Xs_���K���*�>��4�����ĭ��ZV��
�cw��6�������J�Xq�4�<�3�X�nH;���k�v���Èڶ���쫽uO�P?�Ŋ��F�"*nւ�J&�чY�����Z�t~?��o����̕����oZ:s�K�FnӾ�<f��x�SG	0�_E����I��o)@^��}%��E�ǧi�*�Q�SE�j�+!����v�F��8��ċ�Dƀ��ԩ�П�\�l�\���F�uR�Sڼz�����\����cz����0��{��c(�����h`m?X�3^Ϊ>ٱ����;!��4	��H(a�N���b��_�h��W��WZ��ۄ�|%X�q��l�K�r����Ö�������}ļ��-z��}B�cl�m��N����̧U�ݒ�x�9ٿA�摶��k��
�,�"��OU� ��16���=TL=HL���t���i����/rO��[D�\�:0����	Nm<ֲ��*��̩f�3��'�>�iP�|{>.��x%4�\k|�20��0@��շ'Τ`2n�[.̝Y�1���.�NGIл����tn|l�hޜ��F���L�TeឹAy_N��}�l5��q��y?��>Rć�u̢���h� ̄�H��@@_������Q(I�����.���N�	���s��>V�q�Gܓ�Aՠ�\t�!����Ӣ��_��nʝ��t I��p�1���,@0|�����y�v�U��T�]:lB���G:<t��@�8�]��2��"�_�#�cL�_�t�G�����h�uB*���"ap܋��!�D��69���cي�p{{A���t�A�"F��U�e�K���h`�gԐ��؂���Ϡ47�u�5��� �����o�؇	�j���߸�x~%�jH݅���*~�n��o�5����AXØ��������z��m�"��� _��r̈#d�S��c:���)���(�v���8��rc+��:���%��d~,Ȝ�Է't��iV��&_&ĝ�P�plz7Pn�"��A(�P �o�[��=�ɳ��"��sYD������R��n��0�ǫ��+'��	�i�swn"�8�^�)Y@�·͠�x�K�2Ѐ12�V��wo�?>%}�K��&DL�'g��ak��V���{��;�������ZE��|����{�@~b9`P	� =����J���X�w�:�����c�KF �>i�|I&�j�U��q��&��~��1w�Nb�n�����#b]7Ⱦ�DK	�����[੿�U�9^�}
i���7<�p8�&1�M�I����(4����-��U�ѷ~�Ĕ��ʰ��Ï��&��Z������ƀ�}�i]%l��,��ɽ5$g�F�}:��?� �0/��$~�p}7����;��|J��o�𚛗�J�RB�1�<�Vx�f�h���F���RťJH%}*!�2]�L}*!����q���i���Gm,��ڻ���T�O%�R�)!�rf	��zj,��yM*ٷV�#��J:^cfe�(!ɳ������~�ŗ���,t�z����T�j��$��WRt�N{���C�>$o1aZ��iްQ�L�����>A6;(�����s�AZ�S!ՐJ鰦�ݼƧ�C5�R~*���Y��U��텧a�P��?�#RY"�6����4��T��RI3k����RI3KH��YB*��R)�zWq�Z�+:^�]%g��J9�ֻJάU��-�i�xK�wo)!���6w�<^cAťj�YI�%�R�����~��M���         `  x���KSA �3��W2q��<���5 Jy�ٙaQ؅]`A����RI䒣9̥��g��	�0bb4�,[�HO��yO�K(�*/\��2�
@8h��c���w��� �a��&��V����|�'ͨ��m;-o۹e��fk'�*��X�_�:ϝVE��������j�U�����n�X&��OO�2���z�g0��~틲y���Z_�B�v� �%�Q��u�|��u��;/��)P!�َ�#J4j92��Ç�"��I�Dې8��@���Y�
�8�
iA-bNp�h}����Q�~B�j��O�_6�[f���؀�g]��s5�M&�sы��������ti�wl��V�A�5��O7�y��BUΦ06�P�(�q,2�[����ҫ6i)c^h���i�mi��A*���k6n0�Xsc��m{۹^%�����'Ɠ�ĞA:�˜o�.�7Qe~��iE��zr�m4����JG���$j�V0ԱDa�N��#�!Lj�pB�?���	Y�������"�DQ��o-F5�Pϋ�>�rޅ����!˽q�Q���.ݶL+6��^ˆ��u����l�:���[_���~*�z~            x��]{S[G����S�Xw����V���N���ꧭ1 V@ϧ�Ӓ �t_Bdv�6ɌcP�V����>���=�ޘ����/�����gw�_g�/a��y�_�}�f���`r����?nM�}57_���K?OR�~}UDX�Qo���9+�FL��������?��B�@p����4�ay�>n�}�{�ܧ?O�u�σ���a�`2�^�.�'������/o�����O/���0c�Q��::9�'��Q��!�8<8�Q�eQ���`%�%I��!$5�K�~�м%��Ǚ�\�89����QRr��I�	B�`�t �i��\���߅{��}==V#&U2F��]�/��cFz��R��h��2=U�WᾕY-�*\���r0����`�-J��ѤV4�`��!�o�~x>/T&6��gW�7˱�Ĵ0����dM��k��.&�d�RR%��!��Nc���bn��7���>%�L�'��ofW~���y��w�K��IIo�W��N��&U?"U*�9�_��
���	�5!�:ObV� �P�uTt�4�"��G�Qt|y�7wv���׍nW�NB�r�m��%�QV�u����i�t�'b�܉(7Z��T�SPM��qa���[�lK�q���*!mBJrݒ��&k!�r�[�$\AP�#U��;YR�$]�x2|�t�'��C�j��p��.�^E@uv�$$RҸP�V�-3�qH��ћ-�2
o�"l�O!5i�����jf�5�Om���.��i���6`伅��u�(YG�2����֛
~��ͮ��JK������tU"E�dF�b�5��P��Dy��-�YE�+���ɏ>��w�=8<�+!�M2�N2��R �i�s@�		1��vlw(b��8ki���������`rq����;b�[2U��^:�Đ)]����l�\(�����`�qϙ���?�S'����Z��)$.pt���8�4��:$t�0&X2E��S2u�%����5����� d7��U��A@RxQ��@�@�̃b3%D�))�#gX�b�/��O����Ǻ�JUC��G�������Ktx�)�ֳ���̿�߸�����Lo�Wդ�T���y������G��w������I�������Qp�!q�ʒ8."nے�xS;p��I-�!5�Y��F�SɅ�?g�	�]�8�0Vk[��춳��T����U�v���0w��nYF�:����Q'�|=�(��΀�g�+絊Y�X�
!�Up~�E����޲L�[�u�I�@BB*���"`��?��<�vFaj��*�Tğ��������,>\8�E@��V#�#�j�u�r_�=����?k�}ᄟ�����K�xn<�?@�kW  )�)����́	��N�q$Z�=��@�!.���/y�:�T��X��NΎ�Y�1�C��i�yt�&��.Ng��WW�'W^������{�*~�I6=�p׋���aN|�.����� �ԒQo
�"�V�f�������'s���;8~?'N��[ߕن�OU@��zI� 8�>�8(�!�b�2\z�4h#��:��T�]r7��k�eA2x�望zW�k	�%&i�� |��z5�$5)�!��Р��F��ە�Ub����#�v��e���~v�_�2�u�>j�~�ݣ�Ky�*1Ƅт�;����F�Kn��2pF�!�����O��Cso&�o3E<?%����6��]�;�w~�?O�GiS��܋xWe�M���0)
���ӆ� �$%^a.t��bdE���ۋ]b,��b�J�JJ$���y	��CX���'�I	�(�Jx�JI�7>��f��\ř���`pr0<~��5.��c��}x=Yݚ�*���i���LU���N��Y�y����^�C@�������(�~�)e�A*,�F��$ Oxb��&�����b܇X<ZF�n������ۖ�.n����X�Mw����BM&b":ן8zw���s��@4�݉����]�������������;ƬI=�slij�`�(\�,��"dN���ks�I�#]�1���j�0�B�P�.�^�����G�����Ԅ���Q�w��G �xx��N�G�å��"ѧ�IE�u��;��g�ضg�m�G��.�!�����Z4�G�Q���!�G��G���� !ma�^����w�uP���X����bP��ҏf�0�r�j��Xs���m��N{��n�$�K�a��8��sG5C	μ0R"C*��M�� 9�1�K��/�g�6��L&��YmO����#5д]2;흒��9��(�(�Y�L0��h��Lj�w�2"������e�-k�i����W�Ze	��L��e2M��,	�1'Xt��0�.A����B29�޹ʾX~��f�f>�fs�B�����̧��$������sj(��AF� ��<��@t5
)����y<<K�%�T�����������&��̲U9�y���u�v#�Du�5�{�޽��)������m/	NuU�Z�@* g(��Oi5I�?�^M��^�6ӫ�����l~_�]��f���_���[y��Df���Qy#��f�C�S9E�7DQo���m��� z_泇�^Z��i +I>��FR���>J*U�^�|�>�(I���Y·��/��<=8d (߂i%���g^r�Ϙ�C��H!�r�Fc j�-�J�H+嶙�6�@��3����/XЂf�Sb�dZ[z�g�rg��A��n��" �����uZ�|��%0�'MUT�I�7�E�D����3,��ڽ�/ˣ�c�t�Lg�}���H��6���{�P!{Q�bRc����H��~�w�S�%�kl��E�����FZ��rA~+�D�u��T�y��:
f���&�����hx�/��L��.�� 	�/U:�!i�`0%����>�;�}���!ձX��j#�B(P�<�`mT�Z�X4*����� ��H���j���~U�B����ʶ,�. k�@j�*D+��1��M(/��N8��HFAiLi U	d�u���J�qo�fs�la�+d���V��ݚ�=.�\�_g���/)j��=M\C�.�R��e�*dTD��GB�ZpgD���%�]�>��m�b���J�k�i�K֕�Z
�X���Ҧm�aHX
�M	��!��,
���}�n�ҕ�z]eb�d�p0&�O�X �^Z���#��F9��R�����b_H<i��]`G�0_����M�=+eۄ�}�S���$ٻ��%.��R�"(����:p!-�Z�x�T�Sɍ���]Ι�ֆ����g>��w�m���A�_{��o�wm~��<܅��!j�x�2��Va.�	���X1A�_�n���kK�\�Pi��g�|XUI
ї8�$�e���ۢkf���-��om6o���:w~�=ˑ7��w)^W5n-�=7bن�h� �$�T�" �����@��i�\F��� ���5�]<o���B�[[-5��P|��d�3\�/���i�&�"��a�k$�i�5.x���R�l�V�Ej��ā�����c{;j��V��4�jHb��T�2�Hh��y�OuT$ Ȥ��Ⴏ�T�����B�%)�����]G��Ӡ^<C�0����Z"�#
���c"L�;4�HD2�5��ɻW�X}ŊCR �cY�7X������1g�����J���u=�j����������}��M����*�ܚ���ǃ�Ӌ���)X�aor��x�Zl���<��h��V�m0N��jfx4�a�!�0-��=v����סN�3HyVs�/V���p��KRS�1&J�uh���ǋ����Nޟ_|�?Q������[~Y?m>G-�_��E�1q.�
����Z'.�~���B(�*�:k+�u�Ơ�;�	�m�^/�ա�-��&{�>�*�b�b��y���e��7ᷭ���k}b`K�<N]y�r֤�=0�����D|�^��k���u�@Zy��U   �+�<r�pk��LQ��T�u�]��'��a��`�K��ɤ�m��Ak��R�����È`�s�g�����"�簬]���p�/��������� L@�Kp� ���N��.f ���ꥵ��@D�a|��[0��� 	k�������wW\5�0]R��Gk��J��e��F���D
��h(�Bp
�қ6���wf{z��ћ�[�������fk~UQ�m+�t��'�?G2����\bm��.	甁3���P� 7�#��.Z�!�A"ֽf�ذ`�Ɖ�Lp-A��	9��oƛ�������jv��z�a�Y!2h�SP#�	@Q�VE���҅�~�k��OC@�����~�V2K;+ϤA��v"�z_fI�P�RI!2Ĥ�5�C$�<�h# ~��*Qߋ�9]|�n���5d���T�Bd*p��R�;d���F��d�Yn���<���w�
��lE�MĐ�sE)-D�l8��`�c�Q幇�3��9T�>ӹ��2Og͞۴��I�8��J��iJ�\rv�B{򟋇��2�av37߻XS������@�"�iA:yԎy!d����9������ʚ�����A]N~9ۮ|���+�:՘��<L����N�V}�<Q�JP�t
Dd`GA�e��F&4�"��(rG����� �A�$�w�����RhI���?r����ʰ�����:8΂`�t�e�H�ϩ�/�����|튖����w/�홬_��:޴�g3�*�n]*�����g�'b��D	0RH�q�yJ}*~��RA�K!�aM�u���|tyr�����hp~v��<�uy�}J�]i��!��t���b�8]�<O�
�R�]��/U�V+N)f���xf|�"&�BF���Ŵ���j�N-�Y�7_z�]>��O!�]��զUM��Q����� I�GYP#�R'��V�`k�6��446v;+��{�ilP�1�������cT(.  /�%��aѐ�IG��B+j5%6PYQ�c�:W��5G�#�W���BcQ��xf�����!�Y���"��?�`�����y�}��RI��	�@�ȑAщ㖡@�l�CP�������t��rZgGӣ������K�<���×<�z��Z��-�/%��0so�<�GJ��DQL
)��h�.H�Mq��8��sթc�}�����S�z��������7����w�W�;����#��#�d�2��A�����,(j����^ �%ԗ��ZC�]�%Iz���g�U �Mo�T	�p�ݲ������4��[+� ���)����[�w)���=���7:ݺ��Y�Rj��y���������A�}/~�Kd��#���5q�07�aP�x��Jj�Hņ���톏�	�m;���<(����k��4�仟����&�yX:���L��kn�̝n�U٩$���c���x��s���\�
�*%�Љ�8Y�6vWZ���O^4c��Uz�0һ��<}����=WY�Q-.�JɕSS�A�2XP@'�	��Ƨ��L�Me�*Aux�J�v�7��^�$!*�Tv����ZƐ�4�D����\'�	^��\%��0�eY�Ğ���V��|SA@P4�F�v(+���9�F�����8�~A�k��u�� R�0W�ʀѿ�9�
���}���ș 4�2X"��^���!G���S~�u����\���/ҹ6� ��ٯ�7������Ц�b
L;K�%v\��g��Ҋ�ʂu w���:6����mo@p���Q�4�xr.O�8~���N+t�:������>��������c�?џ�>���m��L�������,0�陌H����ŅQ8��!x'�nuBo�F�>}��E_�j
ߞ��|v(?�����~@������h�Z/�[^c����w5s�j�Os?���f���DI�VpnٞH��X�u�#�"��c��#2�myH�;��������54�8��~Y>��gW�ݹ��։j���$.T��b��3�U\FfQ��.Z��H���e�cZ�����Q%�馩Bg;BGA�>j06E<,�����H	�KeKi屇���ld�.Ӎ�E+۞�~�0��R�1���4���� 8+�i"������/��X�~�d�uE�^4sTRF�a,��xm $��I7��t߼�����1���>�s���r�{�cS���Wr���o���ʎ������nj�Ԛ�%ZD&I��K��'c,��qýA,�ZG��㻭�}ɛ���u��`�?��c��YZ��"��r�~���@���BgmD�B*��VH�-�4(�^`���ŢJ�����m�7�6��E`���Ja-u��Kb�����(��^+�4s�Qc1��e%�J>�nlw�f�s%;�WuLis?���<�7m��f�$�ܮ��R���۪�y���)�K�(S�"��GH���1Oi�Z�T�q���}�[�Ƕ�khXY=���,~yy:��0k��l���]���o8W���L��",Z%0ZF�^�i�����<&����zٜ�T�ƹ-�y��ֵ�Mo��8]zj��iK0����zZ�n�����Ig5�0G"�7+�K��Ă����t�1ѝ*9�{���$\����.f#���L���:��3k kr��q��;� ��"����?���n����b�H=���,!g�LL��K��n�uJ���{�7��p�| �%8>dWWy굔�b����8��Θ���&���|X�f��y���.�{�B�}��Rh�,%�Rt�2T�
��'�,e�Fi��Fpm<�̵]����رu°[|ZS�Ăw���g��=_�r��3%N�|?F�Rr	����������@P q0��qL1��55�o�6�}�˧��ӝ���`�����tg�6�k	fo�:r+���ם���a�d;�jn �<��Yb�ن�g5����/������F�܊�������R���\&��k�M�6�D��x��+��I��#r�uh3��M:��s�թ�~�f��B8����&^��;�R�S^�0�'�I9#@y�|CRȤ����vN�t��<�c�7P����ح�ʛ��+�1moJǵ;�@'Io�$�^�馽@<zOH��x�w��9BF�w�@-�J�`;&�GkV_.��g���#aTI	yP�ZX#�H����?�0�>�m�S�;���!�	��e�%��=�����[L@F��o�L���}ٰ��� ɍ� @ �NC����M#�$`�x��:x���"K x(B�ihd���\ّ�鈔+�|��[NF��*IY��b��5�4�� `}~oP8JCc:�ȕ�X�huz{� ��k�ק�3��0�e��o�Hk�1����,A�^E���b����"�{K���>��pq�&��M�7^��k���������@�F��\�0ag�wx�a�����j��!�����H%�������t.{�c��9Sg�/f��V̗[�րg�n�K�,㊄�}y�����E��E?Z$�������lpNR̋����*Kw�����G ��֪J¤�֚U��@�xi)��O�5:����G��+/�*n��3����Zu�ҹ��u�˂�H�V��栭��ۨ�&�V_G�|D�?:=���M[C����_'2mLۉ�p��1*��uR�,���#��FQj��!2�# �;S���I���~�� 12/�            x�3�L��".Cd�!����� �p�           x����d!��3����#�@�`�e2����v�hq�<	�q �M`�RL�7�я�I%��h� ;p���xԧ���:�gʺp�6����Y`�g;��r>��X�.fʀH7��Q�����A.�,�2� '[W����#�(�\R����|p��[�98-�tlgz[��W���.ܜ@���6A��i�e��~C���5 �=T��&��\�e<�����X�݉�V���L��y_Y���*�I�9*;(�f��<$_�hs�ul��[�	g�覅H�IFغ�to�6�'���$a��ux��ɐ�ٽ_T�!���:̲K�O�l��ձ+����j��Uغ�5O�W]���!�ӣq6v �w#�=xeU͵\�~����QVv ��+G�g]|�Q����D��.ZAN��G�_��s�G[5����f]8[��L��,)+�-0F���5U��KML4�V�{߭�n���,9&����I<b�+Kj��3`�������\���دw̵�v�����Q6���۸7E�������� �            x������ � �            x������ � �            x������ � �            x������ � �            x������ � �            x������ � �            x������ � �             x������ � �      !      x������ � �      "      x������ � �      #      x������ � �      $      x������ � �      %      x������ � �      &      x������ � �      '      x������ � �      (      x������ � �      )      x������ � �      *     x��[Mod��]�G��XK��@~Y0�E2�Mf4���JY���ޫ��-6�����9Ք�>�r��R��j��Z�2ū��.u��|7�%ǉ�i�S󙇍^/���{s=~�c���[Z�w?_�镾�o����?㿯�Rbϓ�$R�:�qd>�XY�����z;�^����t�X�=k�B�{�4���P�(Y
7�F�	L����?_���댸��lT$Lu�tx�)L���$���q��o�R�D5i!��[v����Wgd�W����!�7�j��|sc�,�� �+Sˡ�,E��N�?]�}x���|.l)q��@l���s[��S�"�{�\�#�߿o�=����\�y�w����a��L��X,×�G`�G���s���[)�Ʌ&�0�*�]�W�1��'���=���lQA�����j��[*�P�\u`���7�y{��q��_���N��<28ل$ʤ\�Z�8cG6��o�~���?z{u��a/�^;{6K�x.Oa���h:�7�Ըq��m��������tt.t6E�G�B�Q�CE}I�ܛ��+{C���<��h�3�I����!9T	bC���y�#=��s�:j�b�P�%�X�0�e��x���\�>���(�P�3G0�4Z���{��Ǹ蓿:wS�\V'��5u�%_#�jǎ+��M���>��[1[f��xb+� �9(M�a��S۹��o��!��NNj�ĥ��PԐ��x�)�wBB���?�����d
�}H�B�@g*�>w�:K3���;�;��~?:�ܹm�/����KZ�37������y�����\�1x��M~B@���0E|�B��\��=�h&���C���.�����g�\D�e���x��m�7}�J������3�P�@1N�r��������p=���<*�>0���ZóJPo��Hý>]_��ǻ_o���s��� �!�=N�R3L�\���l�� �7o����?��/����������?�t��#��Pխل�{::�2�95%�g���zZ�TAփ�f�#���3�|�y�n`��D^�D�5i=9/v��?�����{�٤�|A/x_]1�K��`��6.v�K��z�>a���s��z�p�:�-k �du�ѻ �ݥv� 2l�D�� k4�cN�|T�N�7�j�����O��lc��5x��)
��Vi0�;��ի7c7�$���}6m�/ �LГ�08�v�Uϝ�ʛ9��w12�!��?ޏ�t0��Q����#����Jݰ3�����������+����@�s��x��lF�?��'�S,2.�'�\��anS@H1���C���귶��5ڶ���YȎ;��C@ 8=�G�z�<��/��k@�E�[����4Fv���;��&��[|��j,��[ ���$�4���2������	���������AN�IS�&��L����;`s�)b�2<!�~��PB��GwG`��	��F���C�z�$� �����8�px+pi�|E�aer����gU��b8��&���T"f]�#<���I����ڴ2����ޜ������T3\�k��<
|۹��6��BO ��1BJ&���70T!y����M�ͧ�d(����D�O��R�YڸةM��'_ k�W8b:W>͖���$ؘ�c�_���k�+�����y3����X�J9��޺)S8��PFPҠ�֦<Y�n�����no�� �@�G*N�Xd|�I��椠:�^FzYx�3H�j�FyD\r�Z�x�ː��v���4�����1y�9ҝ�HHi�*�a�9���1�Ǜ���3�~Ӊߺ��G}y��$���Ȼ�7�_��\Z�	M��Hcq�w�`C��|���jd�� �R��3���POׯ��*͓�6/�鳖�n��\+����J�V���ϙ���Y�u*xX����H��֭/<ǩ^��,��v����:vo0))*�a1.�-����|=��n�T�#�*�y���b�M�G�H�6dJ�G`�m�
=�y�M(,G��ŕ�c��p]d�y���֩�S��0GX]ȁ��d�^Sʳ���^^���N�P���d�Hَuj�Y!F��z_v[�n�ײk��_�m���Ck�������m|�m�
�K\�@�u��ra&�Q���S���1�u.y��@�8{��f�!�d���;�Sn�ܠ�5�R��b��ZA�����%�+{y��n�䳷����,�a�����!����!�u.�2R�1᰾�ɩ�� �TB�޺٨�6��m�[)�������T<�<T�h�!6�^wn�n�T��+H�����RC}4
%K�
����Ϻ�S���uO\�a���;�3g_3�]ڭ�>�΅�9-���4���2s��&3�c��Q�u.t���:?�W��d���5�.l������D���)x���C�l����V��Яf���٤�i��b���+7��_�J�2�|3��:{#��pci�^��WnN��d0�hX񾸿��g�R;�!��#A��+7�n��ؼ��pZU��P��\�s�����3Wn�̈́�+�����DǼEɸ}dA,�O]�9~�����\���AS#:�i�>�/٥#'��+7��a�"���|w�~���(cZ�!y'�/\�9>�N�24Ý�G��@� �k�{=��wW6�	ݺV	q�Z_wW2�>1�^��dG���~��b9jv����F%�)���(\�eq�K�<���x�BUCV��1�CD��/;m�����v�'��[l2UDY�f����B;.�T�9��y]w��_Ɉ�x���(;�m�/�b�\ftn�j�9�W����D��u���	c%���M�6CE�Q�L���Xqa����Ȧ��i���DRI]�j�y���ƈ��B�z�����o�����凯���{�M�I�U�����>��� �\APŴ���?|���������n�%�a�fH>�B-["���F�g�����͟���78�= ��������7;      +   /   x���,++�42�3�3�447600�43��2��2�F�0����� Z�i      ,      x������ � �      -      x������ � �      .   �   x�-�AN�0 ��+��H��K����c.���;�*��r��k��H�$*md�+-iD%u��c;����D���T���})/�0�*l�V���0�h<������3lq����?��X�����|�����쮣�芒��R���zk���9���ԍ�=�i}0ɯ�5�5N��y:1�����M5      /   �	  x��YɎ�=�� �ܗ�a����KdD��0�l�������{4#ҸD�/��f���-Em�]
���Dɪ�`������Xص�_�hg��G{��>�vy��QI.���v9���跛��q�3�����T(��[�T��0z�����Ð(u���6)yq��U�C�f㶝.§����d�������q�<����#0�� tG=�NA�F�B�EU�RiA��zI���T���S�/'�;���'�?��C�3Z�}>��O�NV_��I���4jQ��rt�D���za�hL)�A�plh��h�]�m��Nwg���s����~qv�E��!�)�T�G�>�`\�8�T���)[F�}6獘c	��8R�&�O�~��?��^�yV��Tk��Т^Ь��(Ρ����';�+�Ƴ�Y:Iv��cN�0�#����������k9�r訄we`n0A�f"׽�.-����Q��� 0얣�魠)3��M���$��m[�+�h�s3\/X�<����mN�Vpŕ���2��O	{1�u1��T;t�$��d�1N�=�����0(K����k��#S�\�?��>��O��w�0�L�{&��Q
ըe/�Q0f���vV|�;A iJa�*8��&Wz��%s�8>>�������� ����F�ᱞ�tN�f.���\�v<��{���eD�ɂz��@SsR6�7�#M�V�V��x��$#,F�q�Us�+!l/�z�����`	���yUK:ZS
e��&a���=OW ��qnQ����9zX�ǌ8�L���� �d�Z����_q�u���'{<Σ���J��_�	�	�V�T=�2�/A���C�i8FO6V�A{���{��Ź�d��4~isHL�q#��rW��81pcy�
��2�5(F+�j�b����؉������!T�a�X1i�^>ő�eb���Ad4K�\[^@"&&H�	�G�X��ގ\��*
o�i�
�)��@�a�b>O_en�Ƨ���!�ޖ?p����6� �f�N��3Έ2�)b
��x�X�;X�V-5
"X��}⻛rT?�a���.$o�^�3|~k��iSx
*v7�ҳ��"�^$C
�&$���)�F�6�ܓI�54,��t����<?��X����{�\^�Ѭ7r�����hO��
M2��R�H ����S��5X�����t8�����`(e�L>�޿�fj��ș�Č�q�ݧ���Ԡ؝r�LB�s8��l//W�>1�*�Rm�r�~9��Hd�SW�X�N�;�'�:��/N�����A�+W
g��l��+�\O�PcS��r��	A�U �
��8��Z-�?���j��^KэP��h�C�`w���0,!T��V�����
�nɠ��]�ܫa�[�ZZg����2#~θd.�Z�H����5���ԥ��#���KN�#F���쒹���rp��1����P����k��o̠�p4����۽���#�vF[&�*k�e�]0bQ����T�v:�"���TB�7f�]8���S���&��. vk���۷d�] <�n�u*!�,�ag;�fp���ؓVoɠ�*�4�:����H��h���2�.�իӕ�>O��L�y���oȠ�0�l�ր�,pU�ue+*�jG2N�ߐA��2�8��K�'�O����	�s�^Wg�]�3�+��7J��+��po����Mt�f(4�σ���7YS�3���vK���]����,(�����wv}�!�Q�`��b�P*S�����5��2��5��adЎ������D�dWg�9}�b�2���
H�%i1�<���}I:�·ׁ��V��S�%��3�.$9.ZV_��a��J�9�YM�b�;3hV�-Vx�)�AF��sYC�=������
���{��;Fev�>�б.����`����(<[[UnS���/���Q������6�-x|���f��e�]���̈́-A�`��}�ъ%hR�ǭ�L�����4"���Py8wpdi�f�x�V�KFNJ��P��k��T7��t��bPߖ1.�
�UGvX����Ɋ�T\��ޞa^p'�8������:Ry6X�QRZ|�h5���`�b��^����58���x�|eE�v��ʯ���h��@��X-�z�5�i�.�Ar]/�*�5c̑�L��Ct�{Qx�덗��- )���X��}w!���%��䎘�k���!�~�-{�ȏ�[��.���İ�c�RP���'Ra�D��A/��*�	p���q�;[��,��G�!4�����߿��	~�����/_�����˚����-K?S��cP�&�V2Hځ$��v�u�h5�=����?.O�V�ۑxeM	���oPV���Z0�1��"����(����/���l���      0   _  x��\�n$�<���W
|?��O{��$��mo�[�n��6�����,J�,1Y�@��
2�H&�S���C]�.��R�"�H6k���1�/��k�r8�.��K�����x;��N�������zm�é����s��o��v���M|� ;%�Z���[��񔟙b��M;}�������_��1�v|0���i�@M�['l�6����K��k�rE�����C��Gw�����s���=c���Tr Dae�4Uh�*%"G��A(�.��Ϩ�㘚h �TM�)���vzZ�y=�XPz\iY'D)鋰^7�Z�B&U}���>6��A�Ł����_?�My5%y�H;em�*%\s�c�"I�D��k)�)6���s�N���LϪ	��S4�������ݴba7�*`c�Y�b���(������px��f�9h�8��ȷ?����7 v��ܚ���o���@��{�\�9��D71#0ܔ}������mY�� �b�_��z��V�a�f¨)�+�X8zJ�l��J��CV���,�O���or����/���e�~tj��S5�Ԥ�W,$�U�!�� ��fc�f���]�t�����s�^MH��@��c��v�Du�b�܍��zQ���/[,Æ�9�s���c����N�{���m����i���"�c$��GEa8���lw��_>}����s>�yw��뇝���������p�ԮTr���#��H��8��p��s�Nq�_�	���'�z�)��iB��%�v������m�NXW�(��{�5i���� ]b�_.�~�O&Mȇ��	���|b�6|��9��Ei|Y�(�:a�7�jRs~|�'|AR��	��S4e�ri�].x>�C��3��0^֢ˈ��f�H�2��UM=�6��AzƂ�����>���;5�M)^����>��}1R��A���H.V���S����O|�'�ΧO����	�f�\b�6�LU��&w\<M1�.B�Ps�ٖ�K|��$5ޞ���D�C��D5��\ ����~���w�j���ǖO]�Pr�����#.�1�оg�c���j|�5���ݚ;nM�]��Bm���3�'����8���Y�`��	���nwC��_�x�����#���8F�q���z�ǧz��+���Wz�=~�]Z���}��ә��O_�W콏���ӉOS��m�8��FÏ�?�Zb��\d:��� ��F���
�<LK�9谗��?�>�v�Z�'�;�S0[���M>��X6v��L���:��"F����-����4���A[ȁ�,����ة������u��7�����,z���{���.�7�
���l������[>���B��]R��5*��_Z>>?}G_p�_���9tggWC�1	h*clq��c��]gi�O̨��T �j�F�kM��"u�"B6����p��s��f���_���K��_/��0�O���C;ݞ�{�Y�9��1>�����j<E�"�d[u*�8�|>���h�Q}-N�Zᤈ�U<�9���=�aZ��A.�,�VZiB?����^_N�Q��У�%e� jЀkyQ8��`�w�H��A�c=EY(b�N(��2�+n������n��`��C-A�FX�D������g� ���9`'�\�.׫�M�-Kj���go��E)�W'��T'��Tu�t-���(�N�%�2׻R7����0��s�k��F��;5�N)^M��2f�]�(�,'>�p��*�>h (0���M:����/v��@�dtB�\q"�e�Ǩ��`d4=(9���9�M�����a��}v�?f���rJ��$�vMX�A���ْ��6���՘|�%|3��뇝�)�8��o�X�A��h�)�*�5׀�m� �6�,�8<esОq�[��a�hʳ)�k�8���N�Z �k0�	Q:dar+�E�:og��S,�v�D`�l«	�weT,�F�+��I��&�6�ըt���`�9>]BˁoV;O4 v��N�?T;��T����v0Yd�q˫Kuc�E`XRr1:�<�v�s�7h��{�	��S4u�6%y}��ғ�+YNI!F̶&��*X!���{�+㮓�A;Ło�RMȇ��)�f�}��6�;�n2�.���s��DƳ�p���jp��J>�F�/���m�+~�@��������YI���{m������%�b-9�a��A�ło>"�h �TM�5�y�����֦ a�>���t"�\z1��2���s�%���Ü	��S3U�;�x]���m&��[j'��Ta�4"�\K g�8���9𭇉�a�h�2��x���n��R�RZ����N�J,��Mӣmr���A�Ł�u��a�dʪ	�k�8��L�nYyۅ7�۪ߎθ��⊲�y;�R|:S��Z�8�ة�JW�u��),�Fm�rLV�Ia��5��,��Q(/���F����ް8p�:qB<�TLmW|��͊�ںc�ك_*Yd��S5Q�R}���P[�T'�xՉ,��}��Y���C�`8�O�':���%�iu"��T"�V'�R|��
�`��X��Z�T�#N�=��7>}�Ł3�'�;�S��l��U'�X6v h6zA-eӡ��1�N�(�u2Eg4�c#�b�?�N�h���$C,�j�:���l��.�{n l�E$�����}$�>�\�9��pPT1�k�B��ի�(7^!f�ݪ$п�3M�q�\Μ�����-�c��,����Q��祡,��gi9h��Ʃh0��
'ɂ� �Ʉ3�3_|��$�\�����߲ສ���Q�6�������sP�{ -n�.,oZ����mT����d>�z��P�p�P;e�����7l�lt��5�A<k���I\:�jjqòe6�m��[��a�h�'���u�,�Ɲ�I��;�E�:Q���W�Mú�	�	�nŃ�rI�4�M�+�KG�F��)|����+�&��N�{�쾢��x��[D �.�z�1�v^((^�\�y�ӿG"�z銲�N�e����w>�R+�\�׋.��	V���*d^����HE��<'�ntA��?� �W��Y$��v��|��Gz��K�в���Ha��R	��R���῜�7��9�N�s�N ��m_�8J��?�����      1     x��S�n�1�s��(v�; 1�������V��x}�ނ:���|Q9��9'��5N���Ln�������X��VkA����u\K�����3o�x���������ۍ&5���6�ˠ��/�mv8�W��pۺݹ���.3g�"�ã���\�]�;zT���f���ō3xKaY�O���o6�PY���Բ|tG@�򚁙�f�j%m�eiTm��5�D@���z39��T�A�>��8��ôro�f�nt�������&��)�c4�<�g�FZ��2�ш����zm>�h{�鈝�F��{A���ψ���>�:[++�՟����)�6=�:X�A�V�3��j��x�e����)/�LSz�fw�;������ST��$�gr�i����I�)V��1+��$S�����9��w�A'{i��A(����Кa	�i�攤3�
�q@�}ԓ!Jo��W]���9�k2��6y�A}��<�����S:��-��iFՖ)��0��u^�].�_#�      2   �  x���Yo�6ǟ�Oa�%O��W�� �9v�&��ζ�"���͚"�$��(��;�� ��d��o���q8��/��F?X0�C`	�]�����#��VK��=ȵq]%�[i;��	���(lE���0bͰ�l���>pH���%����Ms��Nhei$��i�4��1`J���pa��`O���;6���B�˪��vs��u�t���֞��z?BkxmǂLw�j�?Lq�N�������W��v�Vw�{�k���p_4�G�L'pK�G+D����0e}^-vHCgl��4���^EG5��,��ΘP6�M��Js�!!�IA&c
c����U�E������ߘ�[�*!��a�P"+�_
�G�z Te�^<�MGqY�?��<.}>>�R�J�z���& �T�n5h��!�b��f،Lf=(,�%t]~�)X��asɦ߰Thf?ÔK�FO-��LҬ�1�qɬ=��P�L���͙:]Џ?�~��O�RVH����L4V�0�-��7�{�NS)���X�7lr-R�\*�J��"�i�Z>c�[��`D*8��[���R�B�����j�!;��aT�ۍ�����V�f��N�@}�a��~ǎ�pew����?��QE��s2�\ʅc�6��.�rN���|sh�`�u8x9�h�uF2�g+ܰqc���>&��M�#�ߠ��Ҍ1�퀋�}f|ćL)��0a�x���r\|�����C�D�������?
����*������C|?ș�C�Ъ�@���͖Y�w	���QI,�?����Zϻ������uz�B=��
���	�ޠ&�Z�A5~Mo�J�%�A�^�7H��7�7س�Z-�J'���TϢWT	AT	Uz��jl� ��OͿK�K���Tl$�h�؞�V�DL��Y����C�dx�������1L��������T��lu$���(�������8�O=�T�g����kl��s�0��X
�X�����,�=���&R���I}���`�Ą�'xu�K�^�T-���Q�]d� 6��86�гB���V4��e�2.���nnt*Bc���x��?��w�6 ���4ҵޓVZ�P.X�gO�`%�H�D֛�$N�VZ����4���V�r���n�c_�      3      x������ � �      4      x������ � �      5   Z   x�]˻�0�����$�B�|B�`���/u�k��@���,�ɬ��V�r������3�T���L"�����8����ʱ:�>D��      6      x������ � �      7   ^   x�m�1� @��ޥ��V�..��*Q������[����ç��z�]{a��)
%��,b�RXS��3��U\,�Fh��"���KE��5�e�m�.�#G      8      x������ � �      9   5   x�3I1I�HK5�ML45�511J�M�4K�50L25J157H�0�L-����� �
�      :   "  x�u��N1EםOAr''q�-l����B�=)�M�����5ZҔBG����{�f�I�Ή�n����|�u���"��e�_��c�I2bL=B�T!s-���]��4aR�Q���꠆Z!�R��B���Y����˲^N6�"(�bm����g��q�#���ڿ�YH�E�P8 rJ@�`	�ѵ�?c�r6�Ra�À}�߭�e��ٟ�}(�/�Fe 9	�sZG��u�@�~��m��<:��N�����uD84j2*o��e��
އTK��s��X�g��i��:��      ;      x������ � �      <   B  x����nG��WO�`1�å˅ �6d9A���+�d}�ҮcԖ���XK�3��#���� �FP��l&�e�4[���X�>��χO�]�������J��Y&���=�=8��YH����L�ĔdCC�d!�Рx' �vq�R	<�\��,g������|6�|c���j���[_�U�`&hD��9� A�@��s#����2|��8��~�����˫��殯��oe��]�Uk&�NZ��g��C��CG��F�zwϚO��?_.N������͖߿�����b�s�| @.�O��s���������t�;8�/���R�_wS�㩞�����n����єN�!)��\nBHJ�dI,�*���V��B����~8}\NO���5�J���E)Z!��Io wXB*�*���0�?��~'���P��ԑM���nʑt�3i$:��KP-ح��d�jKĞ������~��l��z�����)2]���Vr�,�I����
[�am�қ�$���T����ɜ���jz����_��LQ��� 3>�"��Hբ�^�W�O8`�b 1*���5ۢ�{a�D���l��2��91r�o lt�C��Q��sa�wЌM�lK,��0�y����VJHF���7��*UgHl�B����&�޽�� ��K��DV�+��ٔ����JWnݾa���a�밌Ԁ��M�pQ�CJ:L�4R�o l��C���|j�sP'&�G��NT���C�<�D����0+�E��Xݨ#^��(;B̡eXF!l���3,��b<Q�(DQ��e�r˦!�����o���v�ė      =      x������ � �      >      x������ � �      ?      x������ � �      @   7   x���  �7�Ee?��	�?����I���S<m+|��k�H�xf�/pG      A      x������ � �      B   �   x���Mn� ���s*�	�e��� ����1`E�}�_��l����&}"t�q��s���nFɍ G��q֎�R�}ip�K�;���@�a���k���S���倘�J�Gj���`�P�;��L��h�Ľ>�]!�nT��	ET8Z$���z���8�\���p#�P:z��G�jMy�r|'nے�B˝	�o�P�{��؈���p����	�rf      C   �   x���;�0@��\�(�������$�= m��q{*���g�hr�<r1@����Grb"aTg���Õ��7b�ے�����P~���ؖ��V�EU�@�8c"q2d#.����O�}�����>�4?      D      x������ � �      E   5   x��L�0H4KN�M�LM�51�0�M44M�5L5�H6I30O�0�������� �
�      F      x������ � �      G   �   x����C1�q/d0��%���t��4�]�þ������+�h;O�zYNe=��w�b��_���8���f�	� tI�)�2K�Te��)kn 	UxVl��M�%N�Tz�������h�Υ(����Y��#ᆐ�C	'��a|�c�/�1K      H      x������ � �      I      x������ � �      J      x������ � �      K      x������ � �      L   �  x���M�1�����U�؉s!.�m�Vڋ�a��� Z@����(�V+�)�x�<���)SagR�Zh�N���f��q;e�(#(�՜A�
�9�j�=�ɦ�Z{~�؊o8�A^��xN��&ӗ��r���L~T���I����6��U����[tPB��{k���4����2���Jk��]j*�|�k7j�#�UdBͱ��qr*~:��?�Fk]~N0����>���,@�\GZ��	XPg�(��i,�c�@��Sa,Sj8޵)˱���|����Y��wu�_�x:��������v��m߽}ؽ.��s�0��F��Ă!t�D��`+Pp�+��3F�j}���7t��ti�k]�Wv�
��r;�f�Jim`ȃz� ra�5ao<��۾k[�_�[{��yv�Ș�,�x��l~a���      M      x������ � �      N      x������ � �      O      x������ � �      P      x������ � �      Q      x������ � �      R      x������ � �      S   �  x��U۱C)����;�m0���	����d29X�mIt�:��D�Ȍ��t��=��}m	ujׂ��ț3]�f�Tn�_�R�9�zO�cN��)y�+Z}Cʡm�5�E��Q���f�ї�z�+mn��Y$�6Y�KG�f�5���M����9��/B=����[��yFZq��؞$��Em��T�S����h�o�HR��q����å;����k����F%�W$�ɑ�h�����1�u�����9���˪�ai@�:Pv�e����N�\�n_��ֶ~�ݣ�GN50�.�|�F'���7gd�=r���:�����g$$onm�<�}D*W<qx�)ɪE�W��������;o��J(SW��:���n�揻;�і�4�7�i��.��h{B�����JSҳ�`i�b0�lZ�������0	����-��ہy4mIM�
�~1�ƘR�6~�}�0_o�8q�wa�_}~�v|�.a��V��h�;g}��Z�oM�!g�9i�xؐ�5/7l,.�8�[��e2��道�l_~�b��g� .Dv��~Ȉ���}z����m�q�co����8�t�6��D�z�M�>��&$�G!��|�Cx�خ�v��_N��_\
	C
��K����q��A�ȗ�Q�|�ёDSC��5N���~���B��      T      x������ � �      U      x������ � �      V      x������ � �      W   �   x�u�Aj1 ��W�v-K��%[�iiR�d!������0#�M����[��Z�d&i��!t�&��#�iw`"�����)��$����ȜZ��XaL����DO���������Oi����5_K߶�e���0�2� 1�VK���_��_ᲄ��;�     