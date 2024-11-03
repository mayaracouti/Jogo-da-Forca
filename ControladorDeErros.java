public class ControladorDeErros implements Cloneable
{
    private int qtdMax, qtdErr=0;

    public ControladorDeErros (int qtdMax) throws Exception
    {
        if (qtdMax <= 0)
            throw new Exception("Quantidade de máxima ");
        
        this.qtdMax = qtdMax;
    }

    public void registreUmErro () throws Exception
    {
        if (this.qtdErr == this.qtdMax)
            throw new Exception("Quantidade máxima de erros atingida");
        
        this.qtdErr++;
    }

    public boolean isAtingidoMaximoDeErros  ()
    {
        if (this.qtdErr == this.qtdMax)
            return true;
        
        return false;
    }

    @Override
    public String toString ()
    {
        return this.qtdErr + "/" + this.qtdMax;
    }

    public boolean equals (Object obj)
    {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj.getClass()==this.getClass())) return false;

        ControladorDeErros cde = (ControladorDeErros) obj;
        if (cde.qtdErr == this.qtdErr && cde.qtdMax == this.qtdMax)
            return true;
        
        return false;
    }

    @Override
    public int hashCode ()
    {
        int ret = 1;
        ret = ret * 2 + ((Integer) this.qtdMax).hashCode();
        ret = ret * 2 + ((Integer) this.qtdErr).hashCode();

        if (ret < 0) ret = -ret;
        
        return ret;
    }

    public ControladorDeErros (ControladorDeErros c) throws Exception // construtor de c�pia
    {
        if (c == null) throw new Exception("Modelo ausente");

        this.qtdMax = c.qtdMax;
        this.qtdErr = c.qtdErr;
    }

    public Object clone ()
    {
        ControladorDeErros cde = null;
        try
        {
            cde = new ControladorDeErros(this);
        }
        catch (Exception erro)
        {}  // sei que não vai dar erro

        return cde;
    }
}
