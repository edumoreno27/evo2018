//------------------------------------------------------------------------------
// <auto-generated>
//    Este código se generó a partir de una plantilla.
//
//    Los cambios manuales en este archivo pueden causar un comportamiento inesperado de la aplicación.
//    Los cambios manuales en este archivo se sobrescribirán si se regenera el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace API.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class cursogrado
    {
        public cursogrado()
        {
            this.profesor_cursogrado = new HashSet<profesor_cursogrado>();
        }
    
        public int idcursogrado { get; set; }
        public string nombre { get; set; }
        public string contenido { get; set; }
        public string grado { get; set; }
    
        public virtual ICollection<profesor_cursogrado> profesor_cursogrado { get; set; }
    }
}
