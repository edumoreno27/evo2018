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
    
    public partial class servicio
    {
        public servicio()
        {
            this.tutorias = new HashSet<tutoria>();
        }
    
        public int idservicio { get; set; }
        public Nullable<System.DateTime> fecha { get; set; }
        public string tipodepago { get; set; }
    
        public virtual ICollection<tutoria> tutorias { get; set; }
    }
}