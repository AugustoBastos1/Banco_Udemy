from datetime import date

from utils.helper import date_para_str, str_para_date

class Cliente:
    contador = 100

    def __init__(self, nome, email, cpf, data_nascimento):
        self.__id = Cliente.contador
        self.__nome = nome
        self.__email = email
        self.__cpf = cpf
        self.__data_nascimento = str_para_date(data_nascimento)
        self.__data_cadastro = date.today()
        Cliente.contador += 1

    @property
    def id(self):
        return self.__id

    @property
    def nome(self):
        return self.__nome

    @property
    def cpf(self):
        return self.__cpf

    @property
    def email(self):
        return self.__email

    @property
    def data_nascimento(self):
        return date_para_str(self.__data_nascimento)

    @property
    def data_cadastro(self):
        return date_para_str(self.__data_cadastro)

    def __str__(self):
        return f'ID: {self.id}\nNome: {self.nome}\nEmail: {self.email}\nCPF: {self.cpf}\nData de Nascimento: ' \
               f'{self.data_nascimento}\nData de Cadastro: {self.data_cadastro}'


