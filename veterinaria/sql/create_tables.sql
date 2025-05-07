
CREATE TABLE cliente (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2(100),
    correo VARCHAR2(100)
);

CREATE TABLE mascota (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2(100),
    especie VARCHAR2(50),
    cliente_id NUMBER REFERENCES cliente(id)
);

CREATE TABLE servicio (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    descripcion VARCHAR2(200),
    costo NUMBER
);

CREATE TABLE factura (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    fecha_emision DATE,
    total NUMBER,
    pagada CHAR(1)
);

CREATE TABLE detalle_factura (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    factura_id NUMBER REFERENCES factura(id),
    servicio_id NUMBER REFERENCES servicio(id),
    mascota_id NUMBER REFERENCES mascota(id),
    cantidad NUMBER
);
