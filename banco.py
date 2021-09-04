from typing import List
from time import sleep
from models.cliente import Cliente
from models.conta import Conta

contas: List = []


def main():
    menu()


def menu():
    print('===============================')
    print('==============ATM==============')
    print('===============================')
    print('Selecione uma das opções: ')
    print('1-Criar conta')
    print('2-Efetuar saque')
    print('3-Efetuar deposito')
    print('4-Efetuar transferencia')
    print('5-Listar contas')
    print('6-Sair')
    opcao = int(input())
    if opcao == 1:
        criar_conta()
    elif opcao == 2:
        efetuar_saque()
    elif opcao == 3:
        efetuar_deposito()
    elif opcao == 4:
        efetuar_transferencia()
    elif opcao == 5:
        listar_contas()
    elif opcao == 6:
        print('Volte sempre')
        sleep(2)
        exit(0)
    else:
        print('Opção invalida')
        menu()


def criar_conta():
    print('Digite os dados do cliente: ')

    nome = input('Digite o nome do cliente: ')
    email = input('Digite o email do cliente: ')
    cpf = input('Digite o cpf do cliente: ')
    data_nascimento = input('Digite a data de nascimento do cliente(dd/mm/yyyy): ')

    cliente = Cliente(nome, email, cpf, data_nascimento)
    conta = Conta(cliente)
    contas.append(conta)
    print('A conta foi criada com sucesso')
    print('Dados da conta: ')
    print('----------------')
    print(conta)
    sleep(2)
    menu()


def efetuar_saque():
    if len(contas) > 0:
        numero = int(input('Digite o numero da sua conta: '))
        conta: Conta = buscar_conta(numero)
        if conta:
            valor = float(input('Digite o valor do saque: '))
            conta.sacar(valor)
        else:
            print(f'Não foi encontrado a conta com o numero {numero}')
    else:
        print('Não existem contas cadastradas')
    sleep(2)
    menu()


def efetuar_deposito():
    if len(contas) > 0:
        numero = int(input('Digite o numero da sua conta: '))
        conta: Conta = buscar_conta(numero)
        if conta:
            valor = float(input('Digite o valor do deposito: '))
            conta.depositar(valor)
        else:
            print(f'Não foi encontrado a conta com o numero {numero}')
    else:
        print('Não existem contas cadastradas')
    sleep(2)
    menu()


def efetuar_transferencia():
    if len(contas) > 0:
        n_origem = int(input('Digite o numero da sua conta: '))
        conta_origem = buscar_conta(n_origem)
        if conta_origem:
            n_destino = int(input('Digite o numero da conta de destino: '))
            conta_destino = buscar_conta(n_destino)
            if conta_destino:
                valor = float(input('Digite o valor da transferencia: '))
                conta_origem.transferir(conta_destino, valor)
            else:
                print(f'Não foi encontrada a conta destino com o numero {n_destino}')
        else:
            print(f'Não foi encontrada a conta com o numero {n_origem}')
    else:
        print('Não existem contas cadastradas')
    sleep(2)
    menu()


def listar_contas():
    if len(contas) > 0:
        print('Listagem de contas: ')
        print('--------------------')
        for conta in contas:
            print(conta)
            print('--------------------')
            sleep(1)
    else:
        print('Não existem contas cadastradas')
    sleep(2)
    menu()


def buscar_conta(numero) -> Conta:
    c = None
    if len(contas) > 0:
        for conta in contas:
            if conta.numero == numero:
                c = conta
    return c



if __name__ == '__main__':
    main()
