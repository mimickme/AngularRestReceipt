CREATE TABLE ADDRESSNEW
(
	ADDRESSID		INTEGER	PRIMARY KEY,
	SUITE			INTEGER,
	STREETNUMBER 	INTEGER,
	STREETNAME		TEXT,
	POSTAL			TEXT,
	COUNTRY			TEXT,
	PROVINCE		TEXT,
	CITY			TEXT,
	PHONE			TEXT,
	EMAIL			TEXT
);

CREATE TABLE STORECHAIN
(
	STORECHAINID 	INTEGER PRIMARY KEY,
	STOREID			INTEGER,
	ADDRESSID		INTEGER,
	FOREIGN KEY(STOREID) REFERENCES STORE(STOREID),
	FOREIGN KEY(ADDRESSID) REFERENCES ADDRESS(ADDRESSID)
);

CREATE TABLE STORENEW
(
	STOREID			INTEGER PRIMARY KEY,
	STORENAME		TEXT,
	STORETYPE		INTEGER,
	DESCRIPTION		TEXT
);

CREATE TABLE ENUM
(
	ENUMID 			INTEGER PRIMARY KEY,
	ENUMNAME		TEXT,
	ENUMVALUE		INTEGER,
	DESCRIPTION		TEXT
);

CREATE TABLE RECEIPTNEW
(
	RECEIPTID		INTEGER PRIMARY KEY,
	STORECHAINID	INTEGER,
	RECEIPTDATE		TEXT,
	PAYMENTTYPE		INTEGER,
	BASEAMOUNT		REAL,
	TAXAMOUNT		REAL,
	TAXPERCENTAGE	REAL,
	TIPAMOUNT		REAL,
	TOTALAMOUNT		REAL,
	ROUNDAMOUNT		REAL,
	REVERSAL		INTEGER,
	PAYEE			INTEGER,
	FOREIGN KEY (STORECHAINID) REFERENCES STORECHAIN(STORECHAINID)
);

CREATE TABLE ITEMNEW
(
	ITEMID			INTEGER PRIMARY KEY,
	RECEIPTID		INTEGER,
	ITEMNAME		TEXT,
	ITEMTYPE		INTEGER,
	DESCRIPTION		TEXT,
	ITEMPRICE		REAL,
	FOREIGN KEY(RECEIPTID) REFERENCES RECEIPT(RECEIPTID)
);

CREATE TABLE PAYMENTNEW
(
	PAYMENTID 		INTEGER PRIMARY KEY,
	LASTPAYMENTDATE	TEXT,
	NEXTPAYMENTDATE TEXT,
	PAYMENTNAME		TEXT,
	DESCRIPTION		TEXT,
	PAYMENTPERIOD	INTEGER,
	PAYMENTRECEIPTID INTEGER,
	FOREIGN KEY (PAYMENTRECEIPTID) REFERENCES RECEIPT(RECEIPTID)
);

CREATE TABLE PAYMENTITEMNEW
(
	PAYMENTITEMID	INTEGER PRIMARY KEY,
	PAYMENTDATE		TEXT,
	PAYMENTID		INTEGER,
	RECEIPTID		INTEGER,	
	FOREIGN KEY(RECEIPTID) REFERENCES RECEIPT(RECEIPTID),
	FOREIGN KEY(PAYMENTID) REFERENCES PAYMENT(PAYMENTID)
);