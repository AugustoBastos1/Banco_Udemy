from datetime import date
from datetime import datetime


def date_para_str(data: date):
    return data.strftime('%d/%m/%Y')


def str_para_date(data: str):
    return datetime.strptime(data, '%d/%m/%Y')


def formata_moeda(valor):
    return f'R${valor:,.2f}'

