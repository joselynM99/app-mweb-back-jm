PGDMP  +                     }            negocios    16.8    17.0 h               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false                       1262    24819    negocios    DATABASE     s   CREATE DATABASE negocios WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';
    DROP DATABASE negocios;
                     azure_pg_admin    false                        2615    2200    public    SCHEMA     2   -- *not* creating schema, since initdb creates it
 2   -- *not* dropping schema, since initdb creates it
                     azure_pg_admin    false                       0    0 4   FUNCTION pg_replication_origin_advance(text, pg_lsn)    ACL     `   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_advance(text, pg_lsn) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    223                       0    0 +   FUNCTION pg_replication_origin_create(text)    ACL     W   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_create(text) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    236                       0    0 )   FUNCTION pg_replication_origin_drop(text)    ACL     U   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_drop(text) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    235            	           0    0 (   FUNCTION pg_replication_origin_oid(text)    ACL     T   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_oid(text) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    228            
           0    0 6   FUNCTION pg_replication_origin_progress(text, boolean)    ACL     b   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_progress(text, boolean) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    229                       0    0 1   FUNCTION pg_replication_origin_session_is_setup()    ACL     ]   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_session_is_setup() TO azure_pg_admin;
       
   pg_catalog               azuresu    false    230                       0    0 8   FUNCTION pg_replication_origin_session_progress(boolean)    ACL     d   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_session_progress(boolean) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    231                       0    0 .   FUNCTION pg_replication_origin_session_reset()    ACL     Z   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_session_reset() TO azure_pg_admin;
       
   pg_catalog               azuresu    false    224                       0    0 2   FUNCTION pg_replication_origin_session_setup(text)    ACL     ^   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_session_setup(text) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    232                       0    0 +   FUNCTION pg_replication_origin_xact_reset()    ACL     W   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_xact_reset() TO azure_pg_admin;
       
   pg_catalog               azuresu    false    233                       0    0 K   FUNCTION pg_replication_origin_xact_setup(pg_lsn, timestamp with time zone)    ACL     w   GRANT ALL ON FUNCTION pg_catalog.pg_replication_origin_xact_setup(pg_lsn, timestamp with time zone) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    234                       0    0    FUNCTION pg_show_replication_origin_status(OUT local_id oid, OUT external_id text, OUT remote_lsn pg_lsn, OUT local_lsn pg_lsn)    ACL     �   GRANT ALL ON FUNCTION pg_catalog.pg_show_replication_origin_status(OUT local_id oid, OUT external_id text, OUT remote_lsn pg_lsn, OUT local_lsn pg_lsn) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    225                       0    0    FUNCTION pg_stat_reset()    ACL     D   GRANT ALL ON FUNCTION pg_catalog.pg_stat_reset() TO azure_pg_admin;
       
   pg_catalog               azuresu    false    221                       0    0 #   FUNCTION pg_stat_reset_shared(text)    ACL     O   GRANT ALL ON FUNCTION pg_catalog.pg_stat_reset_shared(text) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    222                       0    0 4   FUNCTION pg_stat_reset_single_function_counters(oid)    ACL     `   GRANT ALL ON FUNCTION pg_catalog.pg_stat_reset_single_function_counters(oid) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    227                       0    0 1   FUNCTION pg_stat_reset_single_table_counters(oid)    ACL     ]   GRANT ALL ON FUNCTION pg_catalog.pg_stat_reset_single_table_counters(oid) TO azure_pg_admin;
       
   pg_catalog               azuresu    false    226                       0    0    COLUMN pg_config.name    ACL     D   GRANT SELECT(name) ON TABLE pg_catalog.pg_config TO azure_pg_admin;
       
   pg_catalog               azuresu    false    98                       0    0    COLUMN pg_config.setting    ACL     G   GRANT SELECT(setting) ON TABLE pg_catalog.pg_config TO azure_pg_admin;
       
   pg_catalog               azuresu    false    98                       0    0 $   COLUMN pg_hba_file_rules.line_number    ACL     S   GRANT SELECT(line_number) ON TABLE pg_catalog.pg_hba_file_rules TO azure_pg_admin;
       
   pg_catalog               azuresu    false    94                       0    0    COLUMN pg_hba_file_rules.type    ACL     L   GRANT SELECT(type) ON TABLE pg_catalog.pg_hba_file_rules TO azure_pg_admin;
       
   pg_catalog               azuresu    false    94                       0    0 !   COLUMN pg_hba_file_rules.database    ACL     P   GRANT SELECT(database) ON TABLE pg_catalog.pg_hba_file_rules TO azure_pg_admin;
       
   pg_catalog               azuresu    false    94                       0    0 "   COLUMN pg_hba_file_rules.user_name    ACL     Q   GRANT SELECT(user_name) ON TABLE pg_catalog.pg_hba_file_rules TO azure_pg_admin;
       
   pg_catalog               azuresu    false    94                       0    0     COLUMN pg_hba_file_rules.address    ACL     O   GRANT SELECT(address) ON TABLE pg_catalog.pg_hba_file_rules TO azure_pg_admin;
       
   pg_catalog               azuresu    false    94                       0    0     COLUMN pg_hba_file_rules.netmask    ACL     O   GRANT SELECT(netmask) ON TABLE pg_catalog.pg_hba_file_rules TO azure_pg_admin;
       
   pg_catalog               azuresu    false    94                       0    0 $   COLUMN pg_hba_file_rules.auth_method    ACL     S   GRANT SELECT(auth_method) ON TABLE pg_catalog.pg_hba_file_rules TO azure_pg_admin;
       
   pg_catalog               azuresu    false    94                       0    0     COLUMN pg_hba_file_rules.options    ACL     O   GRANT SELECT(options) ON TABLE pg_catalog.pg_hba_file_rules TO azure_pg_admin;
       
   pg_catalog               azuresu    false    94                        0    0    COLUMN pg_hba_file_rules.error    ACL     M   GRANT SELECT(error) ON TABLE pg_catalog.pg_hba_file_rules TO azure_pg_admin;
       
   pg_catalog               azuresu    false    94            !           0    0 ,   COLUMN pg_replication_origin_status.local_id    ACL     [   GRANT SELECT(local_id) ON TABLE pg_catalog.pg_replication_origin_status TO azure_pg_admin;
       
   pg_catalog               azuresu    false    144            "           0    0 /   COLUMN pg_replication_origin_status.external_id    ACL     ^   GRANT SELECT(external_id) ON TABLE pg_catalog.pg_replication_origin_status TO azure_pg_admin;
       
   pg_catalog               azuresu    false    144            #           0    0 .   COLUMN pg_replication_origin_status.remote_lsn    ACL     ]   GRANT SELECT(remote_lsn) ON TABLE pg_catalog.pg_replication_origin_status TO azure_pg_admin;
       
   pg_catalog               azuresu    false    144            $           0    0 -   COLUMN pg_replication_origin_status.local_lsn    ACL     \   GRANT SELECT(local_lsn) ON TABLE pg_catalog.pg_replication_origin_status TO azure_pg_admin;
       
   pg_catalog               azuresu    false    144            %           0    0     COLUMN pg_shmem_allocations.name    ACL     O   GRANT SELECT(name) ON TABLE pg_catalog.pg_shmem_allocations TO azure_pg_admin;
       
   pg_catalog               azuresu    false    99            &           0    0    COLUMN pg_shmem_allocations.off    ACL     N   GRANT SELECT(off) ON TABLE pg_catalog.pg_shmem_allocations TO azure_pg_admin;
       
   pg_catalog               azuresu    false    99            '           0    0     COLUMN pg_shmem_allocations.size    ACL     O   GRANT SELECT(size) ON TABLE pg_catalog.pg_shmem_allocations TO azure_pg_admin;
       
   pg_catalog               azuresu    false    99            (           0    0 *   COLUMN pg_shmem_allocations.allocated_size    ACL     Y   GRANT SELECT(allocated_size) ON TABLE pg_catalog.pg_shmem_allocations TO azure_pg_admin;
       
   pg_catalog               azuresu    false    99            )           0    0    COLUMN pg_statistic.starelid    ACL     K   GRANT SELECT(starelid) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            *           0    0    COLUMN pg_statistic.staattnum    ACL     L   GRANT SELECT(staattnum) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            +           0    0    COLUMN pg_statistic.stainherit    ACL     M   GRANT SELECT(stainherit) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            ,           0    0    COLUMN pg_statistic.stanullfrac    ACL     N   GRANT SELECT(stanullfrac) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            -           0    0    COLUMN pg_statistic.stawidth    ACL     K   GRANT SELECT(stawidth) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            .           0    0    COLUMN pg_statistic.stadistinct    ACL     N   GRANT SELECT(stadistinct) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            /           0    0    COLUMN pg_statistic.stakind1    ACL     K   GRANT SELECT(stakind1) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            0           0    0    COLUMN pg_statistic.stakind2    ACL     K   GRANT SELECT(stakind2) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            1           0    0    COLUMN pg_statistic.stakind3    ACL     K   GRANT SELECT(stakind3) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            2           0    0    COLUMN pg_statistic.stakind4    ACL     K   GRANT SELECT(stakind4) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            3           0    0    COLUMN pg_statistic.stakind5    ACL     K   GRANT SELECT(stakind5) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            4           0    0    COLUMN pg_statistic.staop1    ACL     I   GRANT SELECT(staop1) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            5           0    0    COLUMN pg_statistic.staop2    ACL     I   GRANT SELECT(staop2) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            6           0    0    COLUMN pg_statistic.staop3    ACL     I   GRANT SELECT(staop3) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            7           0    0    COLUMN pg_statistic.staop4    ACL     I   GRANT SELECT(staop4) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            8           0    0    COLUMN pg_statistic.staop5    ACL     I   GRANT SELECT(staop5) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            9           0    0    COLUMN pg_statistic.stacoll1    ACL     K   GRANT SELECT(stacoll1) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            :           0    0    COLUMN pg_statistic.stacoll2    ACL     K   GRANT SELECT(stacoll2) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            ;           0    0    COLUMN pg_statistic.stacoll3    ACL     K   GRANT SELECT(stacoll3) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            <           0    0    COLUMN pg_statistic.stacoll4    ACL     K   GRANT SELECT(stacoll4) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            =           0    0    COLUMN pg_statistic.stacoll5    ACL     K   GRANT SELECT(stacoll5) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            >           0    0    COLUMN pg_statistic.stanumbers1    ACL     N   GRANT SELECT(stanumbers1) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            ?           0    0    COLUMN pg_statistic.stanumbers2    ACL     N   GRANT SELECT(stanumbers2) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            @           0    0    COLUMN pg_statistic.stanumbers3    ACL     N   GRANT SELECT(stanumbers3) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            A           0    0    COLUMN pg_statistic.stanumbers4    ACL     N   GRANT SELECT(stanumbers4) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            B           0    0    COLUMN pg_statistic.stanumbers5    ACL     N   GRANT SELECT(stanumbers5) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            C           0    0    COLUMN pg_statistic.stavalues1    ACL     M   GRANT SELECT(stavalues1) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            D           0    0    COLUMN pg_statistic.stavalues2    ACL     M   GRANT SELECT(stavalues2) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            E           0    0    COLUMN pg_statistic.stavalues3    ACL     M   GRANT SELECT(stavalues3) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            F           0    0    COLUMN pg_statistic.stavalues4    ACL     M   GRANT SELECT(stavalues4) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            G           0    0    COLUMN pg_statistic.stavalues5    ACL     M   GRANT SELECT(stavalues5) ON TABLE pg_catalog.pg_statistic TO azure_pg_admin;
       
   pg_catalog               azuresu    false    39            H           0    0    COLUMN pg_subscription.oid    ACL     I   GRANT SELECT(oid) ON TABLE pg_catalog.pg_subscription TO azure_pg_admin;
       
   pg_catalog               azuresu    false    64            I           0    0    COLUMN pg_subscription.subdbid    ACL     M   GRANT SELECT(subdbid) ON TABLE pg_catalog.pg_subscription TO azure_pg_admin;
       
   pg_catalog               azuresu    false    64            J           0    0    COLUMN pg_subscription.subname    ACL     M   GRANT SELECT(subname) ON TABLE pg_catalog.pg_subscription TO azure_pg_admin;
       
   pg_catalog               azuresu    false    64            K           0    0    COLUMN pg_subscription.subowner    ACL     N   GRANT SELECT(subowner) ON TABLE pg_catalog.pg_subscription TO azure_pg_admin;
       
   pg_catalog               azuresu    false    64            L           0    0 !   COLUMN pg_subscription.subenabled    ACL     P   GRANT SELECT(subenabled) ON TABLE pg_catalog.pg_subscription TO azure_pg_admin;
       
   pg_catalog               azuresu    false    64            M           0    0 "   COLUMN pg_subscription.subconninfo    ACL     Q   GRANT SELECT(subconninfo) ON TABLE pg_catalog.pg_subscription TO azure_pg_admin;
       
   pg_catalog               azuresu    false    64            N           0    0 "   COLUMN pg_subscription.subslotname    ACL     Q   GRANT SELECT(subslotname) ON TABLE pg_catalog.pg_subscription TO azure_pg_admin;
       
   pg_catalog               azuresu    false    64            O           0    0 $   COLUMN pg_subscription.subsynccommit    ACL     S   GRANT SELECT(subsynccommit) ON TABLE pg_catalog.pg_subscription TO azure_pg_admin;
       
   pg_catalog               azuresu    false    64            P           0    0 &   COLUMN pg_subscription.subpublications    ACL     U   GRANT SELECT(subpublications) ON TABLE pg_catalog.pg_subscription TO azure_pg_admin;
       
   pg_catalog               azuresu    false    64            �            1259    25959    negocio    TABLE     g  CREATE TABLE public.negocio (
    nego_id integer NOT NULL,
    nego_activo boolean NOT NULL,
    nego_direccion character varying(255) NOT NULL,
    nego_nombre_comercial character varying(255) NOT NULL,
    nego_razon_social character varying(255) NOT NULL,
    nego_ruc character varying(255) NOT NULL,
    nego_telefono character varying(255) NOT NULL
);
    DROP TABLE public.negocio;
       public         heap r    	   adminmweb    false    5            �            1259    25964    rol    TABLE     �   CREATE TABLE public.rol (
    rol_id integer NOT NULL,
    rol_keycloak_id character varying(255) NOT NULL,
    rol_nombre character varying(255) NOT NULL
);
    DROP TABLE public.rol;
       public         heap r    	   adminmweb    false    5            �            1259    25969    seq_negocio    SEQUENCE     t   CREATE SEQUENCE public.seq_negocio
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.seq_negocio;
       public            	   adminmweb    false    5            �            1259    25970    seq_rol    SEQUENCE     p   CREATE SEQUENCE public.seq_rol
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.seq_rol;
       public            	   adminmweb    false    5            �            1259    25971    seq_usuario    SEQUENCE     t   CREATE SEQUENCE public.seq_usuario
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.seq_usuario;
       public            	   adminmweb    false    5            �            1259    25972    usuario    TABLE     �  CREATE TABLE public.usuario (
    usua_id integer NOT NULL,
    usua_activo boolean NOT NULL,
    usua_apellido character varying(255) NOT NULL,
    usua_correo character varying(255) NOT NULL,
    usua_identificacion character varying(255) NOT NULL,
    usua_keycloak_id character varying(255) DEFAULT NULL::character varying,
    usua_nombre character varying(255) NOT NULL,
    usua_nombre_usuario character varying(255),
    usua_telefono character varying(255) NOT NULL,
    usua_tipo_identificacion character varying(255) NOT NULL,
    usua_negocio_id integer NOT NULL,
    usua_rol_id integer NOT NULL,
    CONSTRAINT usuario_usua_tipo_identificacion_check CHECK (((usua_tipo_identificacion)::text = ANY (ARRAY[('CEDULA'::character varying)::text, ('RUC'::character varying)::text, ('PASAPORTE'::character varying)::text, ('PLACA'::character varying)::text, ('INTERNACIONAL'::character varying)::text, ('CONSUMIDOR_FINAL'::character varying)::text])))
);
    DROP TABLE public.usuario;
       public         heap r    	   adminmweb    false    5            �          0    25959    negocio 
   TABLE DATA           �   COPY public.negocio (nego_id, nego_activo, nego_direccion, nego_nombre_comercial, nego_razon_social, nego_ruc, nego_telefono) FROM stdin;
    public            	   adminmweb    false    215   �m       �          0    25964    rol 
   TABLE DATA           B   COPY public.rol (rol_id, rol_keycloak_id, rol_nombre) FROM stdin;
    public            	   adminmweb    false    216   %n       �          0    25972    usuario 
   TABLE DATA           �   COPY public.usuario (usua_id, usua_activo, usua_apellido, usua_correo, usua_identificacion, usua_keycloak_id, usua_nombre, usua_nombre_usuario, usua_telefono, usua_tipo_identificacion, usua_negocio_id, usua_rol_id) FROM stdin;
    public            	   adminmweb    false    220   �n       Q           0    0    seq_negocio    SEQUENCE SET     9   SELECT pg_catalog.setval('public.seq_negocio', 1, true);
          public            	   adminmweb    false    217            R           0    0    seq_rol    SEQUENCE SET     6   SELECT pg_catalog.setval('public.seq_rol', 1, false);
          public            	   adminmweb    false    218            S           0    0    seq_usuario    SEQUENCE SET     :   SELECT pg_catalog.setval('public.seq_usuario', 14, true);
          public            	   adminmweb    false    219            V           2606    25980    negocio negocio_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.negocio
    ADD CONSTRAINT negocio_pkey PRIMARY KEY (nego_id);
 >   ALTER TABLE ONLY public.negocio DROP CONSTRAINT negocio_pkey;
       public              	   adminmweb    false    215            ^           2606    25982    rol rol_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (rol_id);
 6   ALTER TABLE ONLY public.rol DROP CONSTRAINT rol_pkey;
       public              	   adminmweb    false    216            b           2606    25984 $   usuario uk_ews7kacxgiys2gxep8qonewd8 
   CONSTRAINT     n   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT uk_ews7kacxgiys2gxep8qonewd8 UNIQUE (usua_nombre_usuario);
 N   ALTER TABLE ONLY public.usuario DROP CONSTRAINT uk_ews7kacxgiys2gxep8qonewd8;
       public              	   adminmweb    false    220            X           2606    25986 $   negocio uk_goeswnmvsuqtb8063wek9ogv7 
   CONSTRAINT     p   ALTER TABLE ONLY public.negocio
    ADD CONSTRAINT uk_goeswnmvsuqtb8063wek9ogv7 UNIQUE (nego_nombre_comercial);
 N   ALTER TABLE ONLY public.negocio DROP CONSTRAINT uk_goeswnmvsuqtb8063wek9ogv7;
       public              	   adminmweb    false    215            d           2606    25988 $   usuario uk_h42lmj6pnpa2b1fpsk7veky7i 
   CONSTRAINT     f   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT uk_h42lmj6pnpa2b1fpsk7veky7i UNIQUE (usua_correo);
 N   ALTER TABLE ONLY public.usuario DROP CONSTRAINT uk_h42lmj6pnpa2b1fpsk7veky7i;
       public              	   adminmweb    false    220            `           2606    25990     rol uk_ify3fdl8lksyxuu78unlh69s1 
   CONSTRAINT     f   ALTER TABLE ONLY public.rol
    ADD CONSTRAINT uk_ify3fdl8lksyxuu78unlh69s1 UNIQUE (rol_keycloak_id);
 J   ALTER TABLE ONLY public.rol DROP CONSTRAINT uk_ify3fdl8lksyxuu78unlh69s1;
       public              	   adminmweb    false    216            f           2606    25992 $   usuario uk_jhwy5k566xopaojp1b95r7y2a 
   CONSTRAINT     k   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT uk_jhwy5k566xopaojp1b95r7y2a UNIQUE (usua_keycloak_id);
 N   ALTER TABLE ONLY public.usuario DROP CONSTRAINT uk_jhwy5k566xopaojp1b95r7y2a;
       public              	   adminmweb    false    220            Z           2606    25994 $   negocio uk_lpi00h8ga74mwr2qjdc3kruxm 
   CONSTRAINT     c   ALTER TABLE ONLY public.negocio
    ADD CONSTRAINT uk_lpi00h8ga74mwr2qjdc3kruxm UNIQUE (nego_ruc);
 N   ALTER TABLE ONLY public.negocio DROP CONSTRAINT uk_lpi00h8ga74mwr2qjdc3kruxm;
       public              	   adminmweb    false    215            \           2606    25996 $   negocio uk_omfdwtfx70wkjqqdqvtldswoh 
   CONSTRAINT     l   ALTER TABLE ONLY public.negocio
    ADD CONSTRAINT uk_omfdwtfx70wkjqqdqvtldswoh UNIQUE (nego_razon_social);
 N   ALTER TABLE ONLY public.negocio DROP CONSTRAINT uk_omfdwtfx70wkjqqdqvtldswoh;
       public              	   adminmweb    false    215            h           2606    25998    usuario usuario_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (usua_id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public              	   adminmweb    false    220            i           2606    25999 #   usuario fk6uv8jv30h5h8wnfpbp894df25    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT fk6uv8jv30h5h8wnfpbp894df25 FOREIGN KEY (usua_rol_id) REFERENCES public.rol(rol_id);
 M   ALTER TABLE ONLY public.usuario DROP CONSTRAINT fk6uv8jv30h5h8wnfpbp894df25;
       public            	   adminmweb    false    220    216    3934            j           2606    26004 #   usuario fkm08y8873w9evnrd8owupc32lq    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT fkm08y8873w9evnrd8owupc32lq FOREIGN KEY (usua_negocio_id) REFERENCES public.negocio(nego_id);
 M   ALTER TABLE ONLY public.usuario DROP CONSTRAINT fkm08y8873w9evnrd8owupc32lq;
       public            	   adminmweb    false    220    215    3926            �   @   x�3�,�.-��KM�O��W0�(*MMJ4�4475�4��01600�4��0�44246����� ��      �   �   x��1� @���*`�1R2 5MD3v��������cҜYBd�d�ɜr2�n������N�V}�Y"=b�Pq���16q˺�O�^u<�G7[ �:�A#�,L��8���Y�k�������&,      �   �   x�mͻ
1@�z�/�d�L��6���M���am�{���{ix±�s|u��y^]�x��' �2��F�MJ���3	�*	���o���[��'���9�"ma�۞k P�̏Z��Xc�D;�2�cJ��1�0I�����T-���FK��A�	�EL     