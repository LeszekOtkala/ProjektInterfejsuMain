/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2012                    */
/* Created on:     2019-10-20 20:50:29                          */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Contracts') and o.name = 'FK_CONTRACT_PRACOWNIK_EMPLOYEE')
alter table Contracts
   drop constraint FK_CONTRACT_PRACOWNIK_EMPLOYEE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Presence_entries') and o.name = 'FK_PRESENCE_PRACOWNIC_EMPLOYEE')
alter table Presence_entries
   drop constraint FK_PRESENCE_PRACOWNIC_EMPLOYEE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Presence_entries') and o.name = 'FK_PRESENCE_RELATIONS_SALARIES')
alter table Presence_entries
   drop constraint FK_PRESENCE_RELATIONS_SALARIES
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Salaries') and o.name = 'FK_SALARIES_PRACOWNIK_EMPLOYEE')
alter table Salaries
   drop constraint FK_SALARIES_PRACOWNIK_EMPLOYEE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Salaries') and o.name = 'FK_SALARIES_UMOWA_WYN_CONTRACT')
alter table Salaries
   drop constraint FK_SALARIES_UMOWA_WYN_CONTRACT
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Contracts')
            and   name  = 'Pracownik_Umowa_FK'
            and   indid > 0
            and   indid < 255)
   drop index Contracts.Pracownik_Umowa_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Contracts')
            and   type = 'U')
   drop table Contracts
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Employees')
            and   type = 'U')
   drop table Employees
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Presence_entries')
            and   name  = 'Relationship_5_FK'
            and   indid > 0
            and   indid < 255)
   drop index Presence_entries.Relationship_5_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Presence_entries')
            and   name  = 'Pracownicy_Obecnoœci_FK'
            and   indid > 0
            and   indid < 255)
   drop index Presence_entries.Pracownicy_Obecnoœci_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Presence_entries')
            and   type = 'U')
   drop table Presence_entries
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Salaries')
            and   name  = 'Umowa_wynagrodzenie_FK'
            and   indid > 0
            and   indid < 255)
   drop index Salaries.Umowa_wynagrodzenie_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Salaries')
            and   name  = 'Pracownik_Wynagrodzenie_FK'
            and   indid > 0
            and   indid < 255)
   drop index Salaries.Pracownik_Wynagrodzenie_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Salaries')
            and   type = 'U')
   drop table Salaries
go

/*==============================================================*/
/* Table: Contracts                                             */
/*==============================================================*/
create table Contracts (
   Contract_Id          numeric              identity,
   Employee_ID          numeric              not null,
   Position             varchar(40)          null,
   Section              varchar(40)          null,
   Contract_Start_Date  datetime             null,
   Contract_End_Date    datetime             null,
   Basic_Hourly_Rate    float                null,
   Basic_salary         float                null,
   Type_Of_Contract     varchar(40)          null,
   Type_Of_Settlement   varchar(40)          null,
   constraint PK_CONTRACTS primary key nonclustered (Contract_Id)
)
go

/*==============================================================*/
/* Index: Pracownik_Umowa_FK                                    */
/*==============================================================*/
create index Pracownik_Umowa_FK on Contracts (
Employee_ID ASC
)
go

/*==============================================================*/
/* Table: Employees                                             */
/*==============================================================*/
create table Employees (
   Employee_ID          numeric              identity,
   LastName             varchar(40)          null,
   FirstName            varchar(40)          null,
   Active               bit                  null,
   Address_Street_No    varchar(40)          null,
   Address_City         varchar(40)          null,
   Address_Postal       int                  null,
   PESEL                bigint               null,
   Account_No           bigint               null,
   Marital_status       varchar(40)          null,
   Number_of_Children   int                  null,
   Birth_date           datetime             null,
   Sex                  varchar(40)          null,
   constraint PK_EMPLOYEES primary key nonclustered (Employee_ID)
)
go

/*==============================================================*/
/* Table: Presence_entries                                      */
/*==============================================================*/
create table Presence_entries (
   Presence_Id          numeric              identity,
   Salary_Id            numeric              not null,
   Employee_ID          numeric              not null,
   Date_of_entry        datetime             null,
   Typ_Obecnosci        int                  null,
   Start_time           datetime             null,
   End_time             datetime             null,
   Hourly_rate          float                null,
   Piecework_payment    float                null,
   constraint PK_PRESENCE_ENTRIES primary key nonclustered (Presence_Id)
)
go

/*==============================================================*/
/* Index: Pracownicy_Obecnoœci_FK                               */
/*==============================================================*/
create index Pracownicy_Obecnoœci_FK on Presence_entries (
Employee_ID ASC
)
go

/*==============================================================*/
/* Index: Relationship_5_FK                                     */
/*==============================================================*/
create index Relationship_5_FK on Presence_entries (
Salary_Id ASC
)
go

/*==============================================================*/
/* Table: Salaries                                              */
/*==============================================================*/
create table Salaries (
   Salary_Id            numeric              identity,
   Employee_ID          numeric              not null,
   Contract_Id          numeric              not null,
   Year                 int                  null,
   Month                int                  null,
   Gross_amount         float                null,
   ZUS_SPOL             float                null,
   ZUS_ZDR              float                null,
   ZUS_EME              float                null,
   Net_amount           float                null,
   Bonus                float                null,
   Piecework_amount     float                null default 0,
   constraint PK_SALARIES primary key nonclustered (Salary_Id)
)
go

/*==============================================================*/
/* Index: Pracownik_Wynagrodzenie_FK                            */
/*==============================================================*/
create index Pracownik_Wynagrodzenie_FK on Salaries (
Employee_ID ASC
)
go

/*==============================================================*/
/* Index: Umowa_wynagrodzenie_FK                                */
/*==============================================================*/
create index Umowa_wynagrodzenie_FK on Salaries (
Contract_Id ASC
)
go

alter table Contracts
   add constraint FK_CONTRACT_PRACOWNIK_EMPLOYEE foreign key (Employee_ID)
      references Employees (Employee_ID)
go

alter table Presence_entries
   add constraint FK_PRESENCE_PRACOWNIC_EMPLOYEE foreign key (Employee_ID)
      references Employees (Employee_ID)
go

alter table Presence_entries
   add constraint FK_PRESENCE_RELATIONS_SALARIES foreign key (Salary_Id)
      references Salaries (Salary_Id)
go

alter table Salaries
   add constraint FK_SALARIES_PRACOWNIK_EMPLOYEE foreign key (Employee_ID)
      references Employees (Employee_ID)
go

alter table Salaries
   add constraint FK_SALARIES_UMOWA_WYN_CONTRACT foreign key (Contract_Id)
      references Contracts (Contract_Id)
go

