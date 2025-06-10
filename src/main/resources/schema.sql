CREATE TABLE users
(
    id         bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    created_at timestamp with time zone NOT NULL,
    updated_at timestamp with time zone,
    name       varchar(50)              NOT NULL
);

CREATE TABLE products
(
    id          bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    created_at  timestamp with time zone NOT NULL,
    updated_at  timestamp with time zone,
    name        varchar(200)             NOT NULL,
    category    varchar(100)             NOT NULL,
    price       integer                  NOT NULL,
    description text
);

CREATE TABLE inventories
(
    product_id   bigint PRIMARY KEY,
    quantity     integer                  NOT NULL CHECK ( quantity >= 0 ),
    safety_stock integer                  NOT NULL,
    created_at   timestamp with time zone NOT NULL,
    last_updated timestamp with time zone
);


CREATE TABLE orders
(
    id         bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    created_at timestamp with time zone NOT NULL,
    updated_at timestamp with time zone,
    user_id    bigint                   NOT NULL,
    status     varchar(20)              NOT NULL
);

CREATE TABLE order_items
(
    id         bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    order_id   bigint  NOT NULL,
    product_id bigint  NOT NULL,
    quantity   integer NOT NULL CHECK (quantity > 0),
    unit_price integer NOT NULL
);

CREATE TABLE notifications
(
    id         bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    created_at timestamp with time zone NOT NULL,
    updated_at timestamp with time zone,
    user_id    bigint                   NOT NULL,
    content    text
);

-- orders.user_id → users.id
ALTER TABLE orders
    ADD CONSTRAINT fk_orders_user
        FOREIGN KEY (user_id) REFERENCES users (id);

-- order_item.order_id → orders.id
ALTER TABLE order_items
    ADD CONSTRAINT fk_orderitems_order
        FOREIGN KEY (order_id) REFERENCES orders (id);

-- order_item.product_id → products.id
ALTER TABLE order_items
    ADD CONSTRAINT fk_orderitems_product
        FOREIGN KEY (product_id) REFERENCES products (id);

-- inventories.product_id → products.id
ALTER TABLE inventories
    ADD CONSTRAINT fk_inventories_product
        FOREIGN KEY (product_id) REFERENCES products (id);

-- notifications.user_id → users.id
ALTER TABLE notifications
    ADD CONSTRAINT fk_notifications_user
        FOREIGN KEY (user_id) REFERENCES users (id);
