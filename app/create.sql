
    create table brand (
       id integer not null,
        name varchar(255),
        passworld varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table brand_store (
       brand_id integer not null,
        store_id integer not null
    ) engine=InnoDB

    create table pago (
       n_tarjeta integer not null,
        titular varchar(255),
        pago_n_tarjeta varchar(255),
        primary key (n_tarjeta)
    ) engine=InnoDB

    create table product (
       id integer not null,
        cathegory varchar(255),
        description varchar(255),
        image longblob,
        name varchar(255),
        price bigint not null,
        product_id integer,
        primary key (id)
    ) engine=InnoDB

    create table product_shopping_cart (
       product_id integer not null,
        shopping_cart_id integer not null
    ) engine=InnoDB

    create table product_store (
       product_id integer not null,
        sotre_id integer not null
    ) engine=InnoDB

    create table shopping_cart (
       id integer not null,
        precio bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table stock (
       talle varchar(255) not null,
        store_id integer not null,
        product_id integer not null,
        quantity integer not null,
        primary key (talle, store_id, product_id, quantity)
    ) engine=InnoDB

    create table store (
       id integer not null,
        address varchar(255),
        hours time,
        password varchar(255),
        user varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table brand_store 
       add constraint FK57bbk6i2gmb8tsrcvincf5fyl 
       foreign key (store_id) 
       references store (id)

    alter table brand_store 
       add constraint FKoq8vbuqlcp0965tkdnrphd1ge 
       foreign key (brand_id) 
       references brand (id)

    alter table client 
       add constraint FKd12b5b88y4ashd4a49olc7t6a 
       foreign key (carts_id) 
       references shopping_cart (id)

    alter table pago 
       add constraint FKo5ojgbbbmt21lne31sbkcf1mw 
       foreign key (pago_n_tarjeta) 
       references client (ci)

    alter table product 
       add constraint FKdvmi3cjwtgjq8kxcvjy3nvikh 
       foreign key (product_id) 
       references brand (id)

    alter table product_shopping_cart 
       add constraint FKpdgjshiffkw6kcvyr380wes4m 
       foreign key (shopping_cart_id) 
       references shopping_cart (id)

    alter table product_shopping_cart 
       add constraint FKocav6bew5039t8kopmqif9eup 
       foreign key (product_id) 
       references product (id)

    alter table product_store 
       add constraint FKo3a4wkp3nkhi1f768spr1pka9 
       foreign key (sotre_id) 
       references store (id)

    alter table product_store 
       add constraint FK5ixdrvrn9b8v6gwrws3s3brsf 
       foreign key (product_id) 
       references product (id)

    create table administrador (
       user_name varchar(255) not null,
        name varchar(255),
        passworld varchar(255),
        primary key (user_name)
    ) engine=InnoDB

    create table brand (
       id integer not null,
        name varchar(255),
        passworld varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table brand_store (
       brand_id integer not null,
        store_id integer not null
    ) engine=InnoDB

    create table pago (
       n_tarjeta integer not null,
        titular varchar(255),
        pago_n_tarjeta varchar(255),
        primary key (n_tarjeta)
    ) engine=InnoDB

    create table product (
       id integer not null,
        cathegory varchar(255),
        description varchar(255),
        image longblob,
        name varchar(255),
        price bigint not null,
        product_id integer,
        primary key (id)
    ) engine=InnoDB

    create table product_shopping_cart (
       product_id integer not null,
        shopping_cart_id integer not null
    ) engine=InnoDB

    create table product_store (
       product_id integer not null,
        sotre_id integer not null
    ) engine=InnoDB

    create table shopping_cart (
       id integer not null,
        precio bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table stock (
       talle varchar(255) not null,
        store_id integer not null,
        product_id integer not null,
        quantity integer not null,
        primary key (talle, store_id, product_id, quantity)
    ) engine=InnoDB

    create table store (
       id integer not null,
        address varchar(255),
        hours time,
        password varchar(255),
        user varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table brand_store 
       add constraint FK57bbk6i2gmb8tsrcvincf5fyl 
       foreign key (store_id) 
       references store (id)

    alter table brand_store 
       add constraint FKoq8vbuqlcp0965tkdnrphd1ge 
       foreign key (brand_id) 
       references brand (id)

    alter table client 
       add constraint FKd12b5b88y4ashd4a49olc7t6a 
       foreign key (carts_id) 
       references shopping_cart (id)

    alter table pago 
       add constraint FKo5ojgbbbmt21lne31sbkcf1mw 
       foreign key (pago_n_tarjeta) 
       references client (ci)

    alter table product 
       add constraint FKdvmi3cjwtgjq8kxcvjy3nvikh 
       foreign key (product_id) 
       references brand (id)

    alter table product_shopping_cart 
       add constraint FKpdgjshiffkw6kcvyr380wes4m 
       foreign key (shopping_cart_id) 
       references shopping_cart (id)

    alter table product_shopping_cart 
       add constraint FKocav6bew5039t8kopmqif9eup 
       foreign key (product_id) 
       references product (id)

    alter table product_store 
       add constraint FKo3a4wkp3nkhi1f768spr1pka9 
       foreign key (sotre_id) 
       references store (id)

    alter table product_store 
       add constraint FK5ixdrvrn9b8v6gwrws3s3brsf 
       foreign key (product_id) 
       references product (id)

    create table administrador (
       user_name varchar(255) not null,
        name varchar(255),
        passworld varchar(255),
        primary key (user_name)
    ) engine=InnoDB

    create table brand (
       id integer not null,
        name varchar(255),
        passworld varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table brand_store (
       brand_id integer not null,
        store_id integer not null
    ) engine=InnoDB

    create table pago (
       n_tarjeta integer not null,
        titular varchar(255),
        pago_n_tarjeta varchar(255),
        primary key (n_tarjeta)
    ) engine=InnoDB

    create table product (
       id integer not null,
        cathegory varchar(255),
        description varchar(255),
        image longblob,
        name varchar(255),
        price bigint not null,
        product_id integer,
        primary key (id)
    ) engine=InnoDB

    create table product_shopping_cart (
       product_id integer not null,
        shopping_cart_id integer not null
    ) engine=InnoDB

    create table product_store (
       product_id integer not null,
        sotre_id integer not null
    ) engine=InnoDB

    create table shopping_cart (
       id integer not null,
        precio bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table stock (
       talle varchar(255) not null,
        store_id integer not null,
        product_id integer not null,
        quantity integer not null,
        primary key (talle, store_id, product_id, quantity)
    ) engine=InnoDB

    create table store (
       id integer not null,
        address varchar(255),
        hours time,
        password varchar(255),
        user varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table brand_store 
       add constraint FK57bbk6i2gmb8tsrcvincf5fyl 
       foreign key (store_id) 
       references store (id)

    alter table brand_store 
       add constraint FKoq8vbuqlcp0965tkdnrphd1ge 
       foreign key (brand_id) 
       references brand (id)

    alter table client 
       add constraint FKd12b5b88y4ashd4a49olc7t6a 
       foreign key (carts_id) 
       references shopping_cart (id)

    alter table pago 
       add constraint FKo5ojgbbbmt21lne31sbkcf1mw 
       foreign key (pago_n_tarjeta) 
       references client (ci)

    alter table product 
       add constraint FKdvmi3cjwtgjq8kxcvjy3nvikh 
       foreign key (product_id) 
       references brand (id)

    alter table product_shopping_cart 
       add constraint FKpdgjshiffkw6kcvyr380wes4m 
       foreign key (shopping_cart_id) 
       references shopping_cart (id)

    alter table product_shopping_cart 
       add constraint FKocav6bew5039t8kopmqif9eup 
       foreign key (product_id) 
       references product (id)

    alter table product_store 
       add constraint FKo3a4wkp3nkhi1f768spr1pka9 
       foreign key (sotre_id) 
       references store (id)

    alter table product_store 
       add constraint FK5ixdrvrn9b8v6gwrws3s3brsf 
       foreign key (product_id) 
       references product (id)

    create table administrador (
       user_name varchar(255) not null,
        name varchar(255),
        passworld varchar(255),
        primary key (user_name)
    ) engine=InnoDB

    create table brand (
       id integer not null,
        name varchar(255),
        passworld varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table brand_store (
       brand_id integer not null,
        store_id integer not null
    ) engine=InnoDB

    create table pago (
       n_tarjeta integer not null,
        titular varchar(255),
        pago_n_tarjeta varchar(255),
        primary key (n_tarjeta)
    ) engine=InnoDB

    create table product (
       id integer not null,
        cathegory varchar(255),
        description varchar(255),
        image longblob,
        name varchar(255),
        price bigint not null,
        product_id integer,
        primary key (id)
    ) engine=InnoDB

    create table product_shopping_cart (
       product_id integer not null,
        shopping_cart_id integer not null
    ) engine=InnoDB

    create table product_store (
       product_id integer not null,
        sotre_id integer not null
    ) engine=InnoDB

    create table shopping_cart (
       id integer not null,
        precio bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table stock (
       talle varchar(255) not null,
        store_id integer not null,
        product_id integer not null,
        quantity integer not null,
        primary key (talle, store_id, product_id, quantity)
    ) engine=InnoDB

    create table store (
       id integer not null,
        address varchar(255),
        hours time,
        password varchar(255),
        user varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table brand_store 
       add constraint FK57bbk6i2gmb8tsrcvincf5fyl 
       foreign key (store_id) 
       references store (id)

    alter table brand_store 
       add constraint FKoq8vbuqlcp0965tkdnrphd1ge 
       foreign key (brand_id) 
       references brand (id)

    alter table client 
       add constraint FKd12b5b88y4ashd4a49olc7t6a 
       foreign key (carts_id) 
       references shopping_cart (id)

    alter table pago 
       add constraint FKo5ojgbbbmt21lne31sbkcf1mw 
       foreign key (pago_n_tarjeta) 
       references client (ci)

    alter table product 
       add constraint FKdvmi3cjwtgjq8kxcvjy3nvikh 
       foreign key (product_id) 
       references brand (id)

    alter table product_shopping_cart 
       add constraint FKpdgjshiffkw6kcvyr380wes4m 
       foreign key (shopping_cart_id) 
       references shopping_cart (id)

    alter table product_shopping_cart 
       add constraint FKocav6bew5039t8kopmqif9eup 
       foreign key (product_id) 
       references product (id)

    alter table product_store 
       add constraint FKo3a4wkp3nkhi1f768spr1pka9 
       foreign key (sotre_id) 
       references store (id)

    alter table product_store 
       add constraint FK5ixdrvrn9b8v6gwrws3s3brsf 
       foreign key (product_id) 
       references product (id)
