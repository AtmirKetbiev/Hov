CREATE DATABASE hov;

CREATE TABLE users (
  	id              	BIGINT GENERATED    BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
  	login           	VARCHAR(20)         NOT NULL,
  	password        	VARCHAR(30)         NOT NULL,
  	create_account  	TIMESTAMP           NOT NULL,
  	last_login 			TIMESTAMP
);

CREATE TABLE spaces (
  	id              	BIGINT GENERATED    BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
  	title             	VARCHAR(100)        NOT NULL,
  	create_space  		TIMESTAMP           NOT NULL,
  	last_update 		TIMESTAMP,
	host_id             BIGINT        		NOT NULL,
  	FOREIGN KEY (host_id)
  	    REFERENCES users (id)
);

CREATE TABLE accounts (
  	id              	BIGINT GENERATED    BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
  	title             	VARCHAR(100)        NOT NULL,
  	login             	VARCHAR(100)        NOT NULL,
  	password        	VARCHAR(100)        NOT NULL,
  	url 				TEXT,
	text             	TEXT,
	space_id            BIGINT        		NOT NULL,
  	FOREIGN KEY (space_id)
  	    REFERENCES spaces (id)
);

CREATE TABLE notes (
  	id              	BIGINT GENERATED    BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
  	title             	VARCHAR(100)        NOT NULL,
	text             	TEXT,
	space_id            BIGINT        		NOT NULL,
  	FOREIGN KEY (space_id)
  	    REFERENCES spaces (id)
);

CREATE TABLE tasks (
  	id              	BIGINT GENERATED    BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
  	title             	VARCHAR(100)        NOT NULL,
  	done            	BOOLEAN        		NOT NULL,
  	task_date        TIMESTAMP              NOT NULL,
	space_id            BIGINT        		NOT NULL,
  	FOREIGN KEY (space_id)
  	    REFERENCES spaces (id)
);