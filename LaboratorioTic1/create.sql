
    alter table client 
       add constraint FKd12b5b88y4ashd4a49olc7t6a 
       foreign key (carts_id) 
       references shopping_cart (id)
