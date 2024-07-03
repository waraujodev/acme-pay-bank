create table  if not exists account_service.accounts(
	id serial PRIMARY KEY,
	number INTEGER not null,
	agency INTEGER not null,
	balance DECIMAL(10,2) not null,
	close BOOLEAN,
	created_at TIMESTAMP not null,
	updated_at TIMESTAMP
);