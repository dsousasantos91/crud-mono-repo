interface ITelefone {
    id: number | null;
    ddd?: number | null;
    numero?: string | null;
    tipo?: string | null;
}

interface IEmail {
    id?: number | null;
    email?: string | null;
}

interface IEndereco {
    id: number | null;
    cep?: string | null;
    logradouro?: string | null;
    bairro?: string | null;
    cidade?: string | null;
    uf?: string | null;
    complemento?: string | null;
}

export interface ICliente {
    id: number;
    nome?: string | null;
    cpf?: string | null;
    telefones?: ITelefone[] | null;
    emails?: IEmail[] | null;
    endereco?: IEndereco | null;
}
