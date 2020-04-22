#!/usr/bin/env bash
echo "shared_preload_libraries = 'pg_stat_statements'" >> $PGDATA/postgresql.conf
echo "pg_stat_statements.max = 10000" >> $PGDATA/postgresql.conf
echo "pg_stat_statements.track = all" >> $PGDATA/postgresql.conf


psql -v ON_ERROR_STOP=1 --username "postgres" -d "12345"  <<-EOSQL
     create database appdemo;
     create extension pg_stat_statements;
EOSQL