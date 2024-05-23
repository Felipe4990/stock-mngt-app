# Stock Manager

Este projeto tem como finalidade fornecer as capacidades básicas para o gerenciamento de estoque de um empreendimento de baixo a médio porte.

O projeto visa habilitar o usuário a consultar informações consolidadas de seu estoque em determinado momento, assim bem como filtra-los por palavras-chave, realizar edições/deeleções on-the-fly em cada um dos produtos consultados, cadastrar novos produtos e ser avisado via sistema de notificação diário dos produtos cujos quais as datas de vencimento estiverem se aproximando de um valor arbitrário e parametrizável.

## Pré Requisitos

* Espaço de 2.3 GB disponível em disco
* Mínimo de 4 GB de Memória disponível
* Windows 10 com build 1803 ou superior 

## Instalação
Executar o Script de instalação presente na raiz desse projeto:
* INSTALL.bat

## Uso
Executar o script de uso presente na raiz do projeto:
* USE.bat

Um arquivo HTML será gerado na área de trabalho do usuário atual.
Executar o arquivo e utiliza-lo normalmente:
* Estoque.html

## Pontos de Atenção
* A execução do script de *Instalação* implica na destruição e recriação do banco
  * Essa solução ainda não suporta sistema de Backup compreensivo automatizado
  * Para a realização de Backup manual, copie o conteúdo da seguinte pasta para alguma outra: 
    * C:\Users\Public\stock-mngt\stock_db
