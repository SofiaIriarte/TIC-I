
    create table carrito (
       identificador varchar(255) not null,
        id_stock varchar(255),
        name varchar(255),
        product_id integer not null,
        quantity integer not null,
        store_and_talle varchar(255),
        user_id varchar(255),
        primary key (identificador)
    ) engine=InnoDB

    create table compra (
       id varchar(255) not null,
        product_id integer not null,
        quantity integer not null,
        type varchar(255),
        user_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table client 
       add constraint FKd12b5b88y4ashd4a49olc7t6a 
       foreign key (carts_id) 
       references shopping_cart (id)

    alter table carrito 
       add column price varchar(255)

    create table compra (
       id varchar(255) not null,
        product_id integer not null,
        quantity integer not null,
        type varchar(255),
        user_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table client 
       add constraint FKd12b5b88y4ashd4a49olc7t6a 
       foreign key (carts_id) 
       references shopping_cart (id)

    create table compra (
       id varchar(255) not null,
        product_id integer not null,
        quantity integer not null,
        type varchar(255),
        user_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table client 
       add constraint FKd12b5b88y4ashd4a49olc7t6a 
       foreign key (carts_id) 
       references shopping_cart (id)

    create table compra (
       id varchar(255) not null,
        product_id integer not null,
        quantity integer not null,
        type varchar(255),
        user_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table client 
       add constraint FKd12b5b88y4ashd4a49olc7t6a 
       foreign key (carts_id) 
       references shopping_cart (id)

    create table compra (
       id varchar(255) not null,
        product_id integer not null,
        quantity integer not null,
        type varchar(255),
        user_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table client 
       add constraint FKd12b5b88y4ashd4a49olc7t6a 
       foreign key (carts_id) 
       references shopping_cart (id)

    create table compra (
       identificador varchar(255) not null,
        date date,
        price varchar(255),
        product_name varchar(255),
        quantity integer not null,
        tienda_talle varchar(255),
        user_id varchar(255),
        primary key (identificador)
    ) engine=InnoDB

    alter table client 
       add constraint FKd12b5b88y4ashd4a49olc7t6a 
       foreign key (carts_id) 
       references shopping_cart (id)

    create table compra (
       identificador varchar(255) not null,
        date date,
        metodo_de_pago varchar(255),
        price varchar(255),
        product_name varchar(255),
        quantity integer not null,
        tienda_talle varchar(255),
        user_id varchar(255),
        primary key (identificador)
    ) engine=InnoDB

    alter table client 
       add constraint FKd12b5b88y4ashd4a49olc7t6a 
       foreign key (carts_id) 
       references shopping_cart (id)
