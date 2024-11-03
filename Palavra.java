public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
        if (texto == null)
            throw new Exception("Texto recebido e nulo");
        if (texto.length() == 0)
            throw new Exception("Texto recebido e vazio");

        this.texto = texto;
    }

    public int getQuantidade (char letra)
    {
        int qtd = 0;
        for(int i=0; i<this.texto.length(); i++)
        {
            if (this.texto.charAt(i) == letra)
                qtd++;
        }
        return qtd;
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
        int qtd = getQuantidade(letra);
        int pos = 0;
        if (qtd-1 < i)
        {
            throw new Exception("Caracter nao encontrado na iezima posicao");
        }
        for (int j=0; j<this.texto.length(); j++)
        {
            if (this.texto.charAt(j) == letra)
            {
                if (i == 0) {
                    pos = j;
                    break;
                }
                i--;
            }
        }
        return pos;
    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    @Override
    public String toString ()
    {
        return this.texto;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        String object = (String) obj;
        if (object.length() != this.texto.length()) return false;
        for (int i=0; i<object.length(); i++)
        {
            if (object.charAt(i) != this.texto.charAt(i))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode ()
    {
        int ret = 1;
        ret = ret * 2 + texto.hashCode();

        if (ret < 0) ret = -ret;

        return ret;
    }

    @Override
    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}
