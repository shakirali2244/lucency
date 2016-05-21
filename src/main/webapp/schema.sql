CREATE TABLE page
(
  id serial NOT NULL PRIMARY KEY,
  hostname character varying,
  path character varying
)
WITH (
  OIDS=FALSE
);
ALTER TABLE page
  OWNER TO postgres;
  
CREATE TABLE link
(
  pid integer REFERENCES page (id),
  cid integer REFERENCES page (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE link
  OWNER TO postgres;
  
CREATE TABLE ig_post 
(
  id serial NOT NULL PRIMARY KEY,
  caption character varying,
  post_time timestamp,
  low_url character varying,
  url character varying,
  thumb_url character varying,
  media_type character varying(10)
  )
  WITH (
  OIDS=FALSE
);
ALTER TABLE ig_post
  OWNER TO postgres;
  
CREATE TABLE ig_location
(
   id serial NOT NULL PRIMARY KEY,
   lat real,
   lon real,
   pid integer REFERENCES ig_post(id)
)
 WITH (
  OIDS=FALSE
);
ALTER TABLE ig_location
  OWNER TO postgres;
  
CREATE TABLE ig_tags
(
   id serial NOT NULL PRIMARY KEY,
   tag character varying,
   pic integer REFERENCES ig_post(id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ig_tags
  OWNER TO postgres;
 

  