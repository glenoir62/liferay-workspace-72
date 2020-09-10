create index IX_EF528065 on Cocktail_Cocktail (groupId);
create index IX_63CF7899 on Cocktail_Cocktail (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_17DF515B on Cocktail_Cocktail (uuid_[$COLUMN_LENGTH:75$], groupId);