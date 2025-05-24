CREATE TABLE IF NOT EXISTS public."Shop"
(
    id character varying COLLATE pg_catalog."default" NOT NULL,
    name character varying COLLATE pg_catalog."default",
    CONSTRAINT "Shop_pkey" PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public."Warehouse"
(
    id character varying COLLATE pg_catalog."default" NOT NULL,
    name character varying COLLATE pg_catalog."default",
    CONSTRAINT "Warehouse_pkey" PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public."Product"
(
    id character varying COLLATE pg_catalog."default" NOT NULL,
    name character varying COLLATE pg_catalog."default",
    price integer,
    quantity integer,
    warehouse character varying COLLATE pg_catalog."default",
    shop character varying COLLATE pg_catalog."default",
    CONSTRAINT "Product_pkey" PRIMARY KEY (id),
    CONSTRAINT "Product_shop_fkey" FOREIGN KEY (shop)
        REFERENCES public."Shop" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "Product_warehouse_fkey" FOREIGN KEY (warehouse)
        REFERENCES public."Warehouse" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);