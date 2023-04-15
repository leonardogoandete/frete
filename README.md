# PrimeiroTrabalho

![](diagrama_de_classes.png)

1) Cliente é uma Pessoa
2) Frete tem vários itens (no mínimo 0) que são armazenados em uma TreeSet
3) Um Frete tem um Cliente
4) O Frete tem situação, mapeada usando enum
5) O peso do Frete deve ser validado usando a interface Validador, para calcular o
   peso total é necessário somar o peso de cada item do frete
6) A classe Pessoa é abstrata
7) A classe ItemFrete é final
8) O número do Cliente deve ser declarado como variável de classe e determinar o
   número total de clientes cadastrados
9) O método getTotal() retorna o número de clientes criados, use para isso a
   variável de classe definida na classe Cliente
10) Faça as modificações necessárias na classe Frete para que seus objetos possam
    ser armazenados em um conjunto ordenado. Use o valor do frete para a ordenação
    dos objetos
    Tema Frete
11) Crie o menu abaixo:
    ```
    1 – Cadastrar Frete
    2 – Pesquisar Frete usando o nome do cliente
    3 – Pesquisar Frete usando CPF do Cliente
    4 – Pesquisar Frete usando cidade de origem e destino
    5 – Listar todos os Fretes
    6 – Listar todos os Clientes cadastrados
    7 – Sair 
    ```
# Observações:
a) Para fazer o item 6 do menu você deve percorrer os fretes e mostrar os clientes
    vinculados a cada frete.

 b) Para montar o menu você deve usar uma enumeração, como abordado em aula.

 c) Enviar projeto elaborado no Eclipse ou compatível, contendo os arquivos fonte do
    projeto (.java). 
