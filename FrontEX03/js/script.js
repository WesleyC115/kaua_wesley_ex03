const Api = {
    turmas: 'http://localhost:8080/turmas'
};

// Função para listar as turmas na página principal
async function listarTurmas() {
    try {
        // Faz a requisição para a API
        const response = await fetch(Api.turmas);
        
        if (!response.ok) throw new Error('Erro ao buscar turmas');

        // Converte a resposta para JSON
        const turmas = await response.json();

        // Pega o corpo da tabela onde as turmas serão inseridas
        const tabelaTurmas = document.getElementById('tabelaTurmas').getElementsByTagName('tbody')[0];

        // Limpa a tabela antes de adicionar os novos dados
        tabelaTurmas.innerHTML = '';

        // Preenche a tabela com as turmas
        turmas.forEach(turma => {
            const row = tabelaTurmas.insertRow();

            // Cria células na linha para número e nome da turma
            const cellNumero = row.insertCell(0);
            const cellNome = row.insertCell(1);
            const cellAcoes = row.insertCell(2);

            // Preenche as células com os dados da turma
            cellNumero.textContent = turma.numeroTurma;
            cellNome.textContent = turma.nomeTurma;

            // Botões de excluir e visualizar
            cellAcoes.innerHTML = `
                <input class="delete" type="button" value="Excluir" onclick="excluirTurma(${turma.numeroTurma})">
                <a href="atividades.html"><input class="view" type="button" value="Visualizar"></a>
            `;
        });

    } catch (error) {
        console.error('Erro ao listar turmas:', error);
    }
}

// Função de exclusão de turma
async function excluirTurma(numeroTurma) {
    const confirmacao = confirm("Tem certeza que deseja excluir essa turma?");
    if (!confirmacao) return;

    try {
        const response = await fetch(`http://localhost:8080/turmas/${numeroTurma}`, {
            method: 'DELETE',
        });

        if (!response.ok) throw new Error('Erro ao excluir turma');
        alert("Turma excluída com sucesso!");
        listarTurmas(); // Atualiza a lista após excluir
    } catch (error) {
        alert(`Erro: ${error.message}`);
    }
}

// Chama a função para carregar as turmas assim que a página for carregada
document.addEventListener('DOMContentLoaded', listarTurmas);

// Função para cadastrar uma nova turma
const formTurma = document.getElementById('formTurma');
if (formTurma) {
    formTurma.addEventListener('submit', async (e) => {
        e.preventDefault();
        const dados = {
            nomeTurma: document.getElementById('nomeTurma').value
        };
        
        try {
            const response = await fetch(Api.turmas, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(dados)
            });

            if (!response.ok) throw new Error('Erro ao cadastrar turma');

            alert("Turma cadastrada com sucesso!");
            window.location.href = "principal.html"; // Redireciona para a página principal após cadastro

        } catch (error) {
            alert(`Erro: ${error.message}`);
            console.error(error);
        }
    });
}
