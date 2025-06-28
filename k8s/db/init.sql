
CREATE TABLE public.consult (
    id_consult integer NOT NULL,
    consult_date timestamp without time zone NOT NULL,
    num_consult character varying(3) NOT NULL,
    id_medic integer NOT NULL,
    id_patient integer NOT NULL,
    id_specialty integer NOT NULL
);


ALTER TABLE public.consult OWNER TO postgres;


CREATE TABLE public.consult_detail (
    id_detail integer NOT NULL,
    diagnosis character varying(70) NOT NULL,
    treatment character varying(300) NOT NULL,
    id_consult integer NOT NULL
);


ALTER TABLE public.consult_detail OWNER TO postgres;


CREATE SEQUENCE public.consult_detail_id_detail_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.consult_detail_id_detail_seq OWNER TO postgres;


ALTER SEQUENCE public.consult_detail_id_detail_seq OWNED BY public.consult_detail.id_detail;



CREATE TABLE public.consult_exam (
    id_consult integer NOT NULL,
    id_exam integer NOT NULL
);


ALTER TABLE public.consult_exam OWNER TO postgres;


CREATE SEQUENCE public.consult_id_consult_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.consult_id_consult_seq OWNER TO postgres;


ALTER SEQUENCE public.consult_id_consult_seq OWNED BY public.consult.id_consult;



CREATE TABLE public.exam (
    id_exam integer NOT NULL,
    description character varying(100) NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE public.exam OWNER TO postgres;


CREATE SEQUENCE public.exam_id_exam_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.exam_id_exam_seq OWNER TO postgres;


ALTER SEQUENCE public.exam_id_exam_seq OWNED BY public.exam.id_exam;



CREATE TABLE public.media_file (
    id_file integer NOT NULL,
    filename character varying(50) NOT NULL,
    filetype character varying(20) NOT NULL,
    content bytea NOT NULL
);


ALTER TABLE public.media_file OWNER TO postgres;


CREATE SEQUENCE public.media_file_id_file_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.media_file_id_file_seq OWNER TO postgres;


ALTER SEQUENCE public.media_file_id_file_seq OWNED BY public.media_file.id_file;



CREATE TABLE public.medic (
    id_medic integer NOT NULL,
    cmp character varying(12) NOT NULL,
    first_name character varying(70) NOT NULL,
    last_name character varying(70) NOT NULL,
    photo_url character varying(255)
);


ALTER TABLE public.medic OWNER TO postgres;


CREATE SEQUENCE public.medic_id_medic_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.medic_id_medic_seq OWNER TO postgres;


ALTER SEQUENCE public.medic_id_medic_seq OWNED BY public.medic.id_medic;


CREATE TABLE public.menu (
    id_menu integer NOT NULL,
    icon character varying(20) NOT NULL,
    name character varying(20) NOT NULL,
    url character varying(50) NOT NULL
);


ALTER TABLE public.menu OWNER TO postgres;

CREATE TABLE public.menu_role (
    id_menu integer NOT NULL,
    id_role integer NOT NULL
);


ALTER TABLE public.menu_role OWNER TO postgres;


CREATE TABLE public.oauth_access_token (
    token_id character varying(256),
    token bytea,
    authentication_id character varying(256),
    user_name character varying(256),
    client_id character varying(256),
    authentication bytea,
    refresh_token character varying(256)
);


ALTER TABLE public.oauth_access_token OWNER TO postgres;


CREATE TABLE public.patient (
    id_patient integer NOT NULL,
    address character varying(150),
    dni character varying(8) NOT NULL,
    email character varying(20),
    first_name character varying(70) NOT NULL,
    last_name character varying(70) NOT NULL,
    phone character varying(9) NOT NULL
);


ALTER TABLE public.patient OWNER TO postgres;


CREATE SEQUENCE public.patient_id_patient_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.patient_id_patient_seq OWNER TO postgres;


ALTER SEQUENCE public.patient_id_patient_seq OWNED BY public.patient.id_patient;


CREATE TABLE public.patient_vital_sign (
    id_vital_sign integer NOT NULL,
    pulse character varying(255) NOT NULL,
    respiratory character varying(255) NOT NULL,
    sign_date timestamp without time zone NOT NULL,
    temperature character varying(255) NOT NULL,
    id_patient integer NOT NULL
);


ALTER TABLE public.patient_vital_sign OWNER TO postgres;


CREATE SEQUENCE public.patient_vital_sign_id_vital_sign_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.patient_vital_sign_id_vital_sign_seq OWNER TO postgres;


ALTER SEQUENCE public.patient_vital_sign_id_vital_sign_seq OWNED BY public.patient_vital_sign.id_vital_sign;



CREATE TABLE public.reset_token (
    id integer NOT NULL,
    expiration timestamp without time zone NOT NULL,
    token character varying(255) NOT NULL,
    id_user integer NOT NULL
);


ALTER TABLE public.reset_token OWNER TO postgres;


CREATE SEQUENCE public.reset_token_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reset_token_id_seq OWNER TO postgres;


ALTER SEQUENCE public.reset_token_id_seq OWNED BY public.reset_token.id;


CREATE TABLE public.role (
    id_role integer NOT NULL,
    description character varying(100) NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE public.role OWNER TO postgres;


CREATE TABLE public.specialty (
    id_specialty integer NOT NULL,
    description character varying(100) NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE public.specialty OWNER TO postgres;


CREATE SEQUENCE public.specialty_id_specialty_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.specialty_id_specialty_seq OWNER TO postgres;


ALTER SEQUENCE public.specialty_id_specialty_seq OWNED BY public.specialty.id_specialty;



CREATE TABLE public.user_data (
    id_user integer NOT NULL,
    password character varying(60) NOT NULL,
    username character varying(60) NOT NULL,
    enabled boolean NOT NULL
);


ALTER TABLE public.user_data OWNER TO postgres;


CREATE TABLE public.user_role (
    id_user integer NOT NULL,
    id_role integer NOT NULL
);


ALTER TABLE public.user_role OWNER TO postgres;


ALTER TABLE ONLY public.consult ALTER COLUMN id_consult SET DEFAULT nextval('public.consult_id_consult_seq'::regclass);



ALTER TABLE ONLY public.consult_detail ALTER COLUMN id_detail SET DEFAULT nextval('public.consult_detail_id_detail_seq'::regclass);



ALTER TABLE ONLY public.exam ALTER COLUMN id_exam SET DEFAULT nextval('public.exam_id_exam_seq'::regclass);



ALTER TABLE ONLY public.media_file ALTER COLUMN id_file SET DEFAULT nextval('public.media_file_id_file_seq'::regclass);



ALTER TABLE ONLY public.medic ALTER COLUMN id_medic SET DEFAULT nextval('public.medic_id_medic_seq'::regclass);


ALTER TABLE ONLY public.patient ALTER COLUMN id_patient SET DEFAULT nextval('public.patient_id_patient_seq'::regclass);


ALTER TABLE ONLY public.patient_vital_sign ALTER COLUMN id_vital_sign SET DEFAULT nextval('public.patient_vital_sign_id_vital_sign_seq'::regclass);


ALTER TABLE ONLY public.reset_token ALTER COLUMN id SET DEFAULT nextval('public.reset_token_id_seq'::regclass);


ALTER TABLE ONLY public.specialty ALTER COLUMN id_specialty SET DEFAULT nextval('public.specialty_id_specialty_seq'::regclass);


ALTER TABLE ONLY public.consult_detail
    ADD CONSTRAINT consult_detail_pkey PRIMARY KEY (id_detail);



ALTER TABLE ONLY public.consult_exam
    ADD CONSTRAINT consult_exam_pkey PRIMARY KEY (id_consult, id_exam);


ALTER TABLE ONLY public.consult
    ADD CONSTRAINT consult_pkey PRIMARY KEY (id_consult);

ALTER TABLE ONLY public.exam
    ADD CONSTRAINT exam_pkey PRIMARY KEY (id_exam);

ALTER TABLE ONLY public.media_file
    ADD CONSTRAINT media_file_pkey PRIMARY KEY (id_file);


ALTER TABLE ONLY public.medic
    ADD CONSTRAINT medic_pkey PRIMARY KEY (id_medic);


ALTER TABLE ONLY public.menu
    ADD CONSTRAINT menu_pkey PRIMARY KEY (id_menu);


ALTER TABLE ONLY public.patient
    ADD CONSTRAINT patient_pkey PRIMARY KEY (id_patient);


ALTER TABLE ONLY public.patient_vital_sign
    ADD CONSTRAINT patient_vital_sign_pkey PRIMARY KEY (id_vital_sign);


ALTER TABLE ONLY public.reset_token
    ADD CONSTRAINT reset_token_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id_role);


ALTER TABLE ONLY public.specialty
    ADD CONSTRAINT specialty_pkey PRIMARY KEY (id_specialty);


ALTER TABLE ONLY public.user_data
    ADD CONSTRAINT uk_nlc4atex50p892vsfhwccm336 UNIQUE (username);


ALTER TABLE ONLY public.reset_token
    ADD CONSTRAINT uk_shiutqgqq3m7hdrlmckbk4am6 UNIQUE (token);


ALTER TABLE ONLY public.user_data
    ADD CONSTRAINT user_data_pkey PRIMARY KEY (id_user);


ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fk2aam9nt2tv8vcfymi3jo9c314 FOREIGN KEY (id_role) REFERENCES public.role(id_role);


ALTER TABLE ONLY public.menu_role
    ADD CONSTRAINT fk2ymscnycm83uqu1ddpkgdryg1 FOREIGN KEY (id_menu) REFERENCES public.menu(id_menu);


ALTER TABLE ONLY public.consult_exam
    ADD CONSTRAINT fk591nrrtt1rqpma2ax5f0u1rr FOREIGN KEY (id_consult) REFERENCES public.consult(id_consult);


ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fk9qphm07p6th93qb8p9fnykvwo FOREIGN KEY (id_user) REFERENCES public.user_data(id_user);


ALTER TABLE ONLY public.consult_detail
    ADD CONSTRAINT fk_consult_detail FOREIGN KEY (id_consult) REFERENCES public.consult(id_consult);



ALTER TABLE ONLY public.consult
    ADD CONSTRAINT fk_consult_medic FOREIGN KEY (id_medic) REFERENCES public.medic(id_medic);



ALTER TABLE ONLY public.consult
    ADD CONSTRAINT fk_consult_patient FOREIGN KEY (id_patient) REFERENCES public.patient(id_patient);


ALTER TABLE ONLY public.consult
    ADD CONSTRAINT fk_consult_specialty FOREIGN KEY (id_specialty) REFERENCES public.specialty(id_specialty);


ALTER TABLE ONLY public.patient_vital_sign
    ADD CONSTRAINT fk_patient_sign FOREIGN KEY (id_patient) REFERENCES public.patient(id_patient);


ALTER TABLE ONLY public.menu_role
    ADD CONSTRAINT fkbhl7xy7xjv54q9vedxuxk2kn0 FOREIGN KEY (id_role) REFERENCES public.role(id_role);



ALTER TABLE ONLY public.consult_exam
    ADD CONSTRAINT fkjmghcc7tn12i5uav4lisb127t FOREIGN KEY (id_exam) REFERENCES public.exam(id_exam);


ALTER TABLE ONLY public.reset_token
    ADD CONSTRAINT fkqtbrpfn6lfgmabbsqn3cv8u9g FOREIGN KEY (id_user) REFERENCES public.user_data(id_user);




INSERT INTO Role (id_role, name, description) VALUES (1, 'ADMIN', 'Administrador');
INSERT INTO Role (id_role, name, description) VALUES (2, 'USER', 'Usuario');
INSERT INTO Role (id_role, name, description) VALUES (3, 'DBA', 'Admin de bd');


INSERT INTO user_data(id_user, username, password, enabled) values (1, 'mitotest21@gmail.com', '$2a$10$ju20i95JTDkRa7Sua63JWOChSBc0MNFtG/6Sps2ahFFqN.HCCUMW.', '1');
INSERT INTO user_data(id_user, username, password, enabled) values (2, 'mitocode21@gmail.com', '$2a$10$ju20i95JTDkRa7Sua63JWOChSBc0MNFtG/6Sps2ahFFqN.HCCUMW.', '1');


INSERT INTO user_role (id_user, id_role) VALUES (1, 1);
INSERT INTO user_role (id_user, id_role) VALUES (1, 3);
INSERT INTO user_role (id_user, id_role) VALUES (2, 2);


INSERT INTO menu(id_menu, name, icon, url) VALUES (1, 'Dashboard', 'home', '/pages/dashboard');
INSERT INTO menu(id_menu, name, icon, url) VALUES (2, 'Search', 'search', '/pages/search');
INSERT INTO menu(id_menu, name, icon, url) VALUES (3, 'Consult', 'insert_drive_file', '/pages/consult');
INSERT INTO menu(id_menu, name, icon, url) VALUES (4, 'Consult Autocomplete', 'insert_drive_file', '/pages/consult-autocomplete');
INSERT INTO menu(id_menu, name, icon, url) VALUES (5, 'Consult Wizard', 'view_carousel', '/pages/consult-wizard');
INSERT INTO menu(id_menu, name, icon, url) VALUES (6, 'Specialties', 'star_rate', '/pages/specialty');
INSERT INTO menu(id_menu, name, icon, url) VALUES (7, 'Medics', 'healing', '/pages/medic');
INSERT INTO menu(id_menu, name, icon, url) VALUES (8, 'Exams', 'assignment', '/pages/exam');
INSERT INTO menu(id_menu, name, icon, url) VALUES (9, 'Patients', 'accessibility', '/pages/patient');
INSERT INTO menu(id_menu, name, icon, url) VALUES (10, 'Reports', 'assessment', '/pages/report');

INSERT INTO menu_role (id_menu, id_role) VALUES (1, 1);
INSERT INTO menu_role (id_menu, id_role) VALUES (2, 1);
INSERT INTO menu_role (id_menu, id_role) VALUES (3, 1);
INSERT INTO menu_role (id_menu, id_role) VALUES (4, 1);
INSERT INTO menu_role (id_menu, id_role) VALUES (5, 1);
INSERT INTO menu_role (id_menu, id_role) VALUES (6, 1);
INSERT INTO menu_role (id_menu, id_role) VALUES (7, 1);
INSERT INTO menu_role (id_menu, id_role) VALUES (8, 1);
INSERT INTO menu_role (id_menu, id_role) VALUES (9, 1);
INSERT INTO menu_role (id_menu, id_role) VALUES (10, 1);
INSERT INTO menu_role (id_menu, id_role) VALUES (1, 2);
INSERT INTO menu_role (id_menu, id_role) VALUES (3, 2);
INSERT INTO menu_role (id_menu, id_role) VALUES (4, 2);
INSERT INTO menu_role (id_menu, id_role) VALUES (5, 2);
INSERT INTO menu_role (id_menu, id_role) VALUES (6, 2);

select m.* from menu_role mr 
inner join user_role ur on ur.id_role = mr.id_role 
inner join menu m on m.id_menu = mr.id_menu 
inner join user_data u on u.id_user = ur.id_user
where u.username = 'mitocode21@gmail.com';

INSERT INTO specialty (id_specialty, name, description) VALUES  (1, 'Cardiología', 'Especialidad en enfermedades del corazón'),

                                                            (2, 'Neurología', 'Especialidad en el sistema nervioso'),

                                                            (3, 'Pediatría', 'Atención médica para niños'),

                                                            (4, 'Dermatología', 'Tratamiento de enfermedades de la piel');

INSERT INTO medic (id_medic, cmp, first_name, last_name, photo_url) VALUES (1, 'CMP001', 'Juan', 'Pérez', 'https://via.placeholder.com/150'),

                                                                        (2, 'CMP002', 'Ana', 'García', 'https://via.placeholder.com/150');

INSERT INTO patient (id_patient, dni, first_name, last_name, phone, address, email) VALUES

                                                                                        (1, '12345678', 'Carlos', 'Ramírez', '999111222', 'Av. Siempre Viva 123', 'carlos@example.com'),

                                                                                        (2, '87654321', 'María', 'Lopez', '999333444', 'Calle Luna 456', 'maria@example.com');
INSERT INTO public.exam(id_exam, description, name) VALUES (1, 'Debe estar en ayunas', 'SANGRE');
INSERT INTO public.exam(id_exam, description, name) VALUES (2, 'Tomar un litro de agua', 'ECOGRAFIA');