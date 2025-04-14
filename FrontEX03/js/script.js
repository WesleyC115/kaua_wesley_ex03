const Api = {
    professor: 'http://localhost:8080/professores',
    atividade: 'http://localhost:8080/atividades',
    turmas: 'http://localhost:8080/turmas'
};
async function CadastrarTurmas(url, dados, formId) {
    try {
        const response = await fetch(url, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(dados)
        });

        if (!response.ok) throw new Error('Erro ao cadastrar turma');

        document.getElementById(formId).reset();
        alert("Turma cadastrada com sucesso!");
        
        return await response.json();

    } catch (error) {
        alert(`ERRO: ${error.message}`);
        console.error(error);
    }
}

const formTurma = document.getElementById('formTurma');
if (formTurma) {
    formTurma.addEventListener('submit', (e) => {
        e.preventDefault();
        const dados = {
            nomeTurma: document.getElementById('nomeTurma').value
        };
        CadastrarTurmas(Api.turmas, dados, 'formTurma');
    });
}

async function CadastrarAtividade(url, dados, formId) {
    try {
        const response = await fetch(url, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(dados)
        });

        if (!response.ok) throw new Error('Erro ao cadastrar atividade');

        document.getElementById(formId).reset();
        alert("Atividade cadastrada com sucesso!");
        window.location.href = "atividades.html";
        return await response.json();

    } catch (error) {
        alert(`ERRO: ${error.message}`);
        console.error(error);
    }
}

const formAtividade = document.getElementById('formAtividade');
if (formAtividade) {
    formAtividade.addEventListener('submit', (e) => {
        e.preventDefault();
        const dados = {
            nomeAtividade: document.getElementById('nomeAtividade').value
        };
        CadastrarAtividade(Api.atividade, dados, 'formAtividade');
    });
}
