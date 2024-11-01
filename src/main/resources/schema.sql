create table ComunidadAutonoma(
ID int not null auto_increment primary key,
CodigoINE varchar(4),
Nombre varchar(60),
Activo int not null default(1),
FechaCreacion datetime not null default now(),
FechaModificacion datetime not null default now()
);
