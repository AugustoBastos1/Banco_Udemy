from models.cliente import Cliente
from utils.helper import formata_moeda

class Conta:

    codigo = 1000

    def __init__(self, cliente):
        self.__numero = Conta.codigo
        self.__cliente = cliente
        self.__saldo = 0.0
        self.__limite = 100.00
        self.__saldo_total = self._calcula_saldo_total
        Conta.codigo += 1

    def __str__(self):
        return f'Numero da conta: {self.numero}\nCliente: {self.cliente.nome}\n' \
               f'Saldo Total: {formata_moeda(self.saldo_total)}'

    @property
    def numero(self):
        return self.__numero

    @property
    def cliente(self):
        return self.__cliente

    @property
    def saldo(self):
        return self.__saldo

    @saldo.setter
    def saldo(self, valor):
        self.__saldo = valor

    @property
    def limite(self):
        return self.__limite

    @limite.setter
    def limite(self, valor):
        self.__limite = valor

    @property
    def saldo_total(self):
        return self.__saldo_total

    @saldo_total.setter
    def saldo_total(self, valor):
        self.__saldo_total = valor

    @property
    def _calcula_saldo_total(self):
        return self.saldo + self.limite

    def depositar(self, valor):
        if valor > 0:
            self.saldo = self.saldo + valor
            self.saldo_total = self._calcula_saldo_total
            print('Deposito efetuado com sucesso')
        else:
            print('Erro ao realizar o deposito tente novamente')

    def sacar(self, valor):
        if valor > 0 and self.saldo_total >= valor:
            if self.saldo >= valor:
                self.saldo = self.saldo - valor
                self.saldo_total = self._calcula_saldo_total
            else:
                restante = self.saldo - valor
                self.limite = self.limite + restante
                self.saldo = 0
                self.saldo_total = self._calcula_saldo_total
            print('Saque realizado com sucesso')
        else:
            print('Erro ao realizar o saque tente novamente')

    def transferir(self, destino, valor):
        if valor > 0 and self.saldo_total >= valor:
            if self.saldo >= valor:
                self.saldo = self.saldo - valor
                self.saldo_total = self._calcula_saldo_total
                destino.saldo = destino.saldo + valor
                destino.saldo_total = destino._calcula_saldo_total
                print('Transferencia realizada com sucesso')
            else:
                restante = self.saldo - valor
                self.limite = self.limite + restante
                self.saldo = 0
                self.saldo_total = self._calcula_saldo_total
        else:
            print('Erro ao realizar a transferencia tente novamente')

