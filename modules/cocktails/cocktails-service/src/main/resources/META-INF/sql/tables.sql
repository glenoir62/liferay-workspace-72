create table Cocktail_Cocktail (
	uuid_ VARCHAR(75) null,
	cocktailId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	image TEXT null,
	description TEXT null
);