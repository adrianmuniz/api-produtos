create table tb_produtos
(
    id                    int not null auto_increment,
    Categorias           varchar(50) not null,
    Marca                varchar(50) not null,
    Preço                varchar(50) not null,
    primary key (id)
);