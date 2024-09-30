# D&N Car - Locações

O "D&N Car - Locações" é um sistema voltado para o gerenciamento de locações de veículos. O sistema foi desenvolvido com foco em facilitar a gestão de uma empresa de aluguel de veículos, automatizando processos relacionados à reserva e locação de carros, renovação de locações e cadastro e listagem de clientes e funcionários.
Esse trabalho faz parte da fase 1 do projeto da matéria de Banco de dados 2.

PARA EXECUTAR O PROJETO: 
1 - Copie o repositório para o seu local.
2 - Certifique-se de que há alguma versão do java (11 ou superior preferencialmente) instalado na sua máquina.
3 - Entre em carRentalCompany > src > carRentalCompany > connection > DBConnection e configure a conexão com seu banco de dados local nessa classe.
4 - Utilize o arquivo dump do repositório com o nome "backupData.txt" no seu postgres local. 
5 - Execute os seguintes comandos:

    	- cd ~/Downloads/carRentalCompany/carRentalCompany/src
    	- javac -cp ".:/home/user/Downloads/carRentalCompany/postgresql-42.7.4.jar" carRentalCompany/**/*.java
    	- java -cp ".:/home/user/Downloads/carRentalCompany/postgresql-42.7.4.jar" Main.java

Adapte o diretório do projeto nos comandos de acordo com a forma que ficou salvo em sua máquina. A biblioteca jdbc já está presente no repositório.

Caso ocorra algum problema neste processo, abra a o projeto em sua IDE de preferência, execute os passos de 1 a 4 novamente e baixe o jdbc postgres no link: https://jdbc.postgresql.org/download/postgresql-42.7.4.jar.

Baixando o .jar, importe ele no projeto dentro de sua IDE e assim conseguirá rodar o projeto.
