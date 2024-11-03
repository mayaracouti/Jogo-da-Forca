public class Tracinhos implements Cloneable
{
    private char texto [];

    public Tracinhos (int qtd) throws Exception
    {
        if (qtd <= 0)
            throw new Exception("Quantidade nao e positiva");
        
        this.texto = new char[qtd];

        for (int i=0; i<qtd; i++)
        {
            this.texto[i] = '9';
        }
    }

    public void revele (int posicao, char letra) throws Exception
    {
        if (posicao < 0 || posicao >= this.texto.length)
            throw new Exception("Posicao invalida");

        this.texto[posicao] = letra;
    }

    public boolean isAindaComTracinhos ()
    {
        for (int i=0; i<this.texto.length; i++)
        {
            if (this.texto[i] == '9')
                return true;
        }
        
        return false;
    }

    @Override
    public String toString()
    {
        String todosCaracteres = "";
        for (int i=0; i<this.texto.length; i++)
        {
            if (i<this.texto.length-1)
                todosCaracteres += String.format("%c " , this.texto[i]);
            else
                todosCaracteres += this.texto[i];
        }

        return todosCaracteres;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Tracinhos t = (Tracinhos) obj;
        if (t.texto.length != this.texto.length) return false;
        for (int i=0; i<this.texto.length; i++)
        {
            if (this.texto[i] != t.texto[i])
                return false;
        }

        return true;
    }

    @Override
    public int hashCode ()
    {
        int ret = 1;
        ret = ret * 2 + this.texto.hashCode();
        
        if (ret < 0) ret = -ret;

        return ret;
    }

    public Tracinhos (Tracinhos t) throws Exception // construtor de c�pia
    {
        if (t == null) throw new Exception("Modelo ausente");

        for (int i=0; i<this.texto.length; i++)
        {
            this.texto[i] = t.texto[i];
        }
    }

    public Object clone ()
    {
        Tracinhos t = null;
        try
        {
            t = new Tracinhos(this);
        }
        catch (Exception erro)
        {}  // sei que não vai dar erro

        return t;
    }
}
