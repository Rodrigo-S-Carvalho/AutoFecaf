    create table tb_veiculos (
        id integer not null auto_increment,
        ano_fabric integer not null check ((ano_fabric>=1750) and (ano_fabric<=2100)),
        categoria varchar(60) not null,
        condicao_veiculo varchar(20) not null,
        cor_veiculo varchar(20) not null,
        descricao_veiculo varchar(3000) not null,
        disponibilidade_veiculo varchar(20) not null,
        marca varchar(60) not null,
        modelo varchar(60) not null,
        motor varchar(60) not null,
        numero_chassi varchar(17) not null,
        placa_veiculo varchar(8),
        preco_veiculo decimal(38,2) not null check (preco_veiculo>=0),
        quilometragem float(53) not null check (quilometragem>=0),
        primary key (id)
    ) engine=InnoDB