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
    
    public partial class padre
    {
        public padre()
        {
            this.hijoes = new HashSet<hijo>();
            this.mensajes = new HashSet<mensaje>();
            this.profesorfavoritoes = new HashSet<profesorfavorito>();
            this.tutorias = new HashSet<tutoria>();
        }
    
        public int idpadre { get; set; }
        public string nombre { get; set; }
        public string apellido { get; set; }
        public string password { get; set; }
        public string email { get; set; }
        public string departamento { get; set; }
        public string provincia { get; set; }
        public string distrito { get; set; }
        public string direccion { get; set; }
        public Nullable<int> celular { get; set; }
        public Nullable<int> dni { get; set; }
        public string fotourl { get; set; }
    
        public virtual ICollection<hijo> hijoes { get; set; }
        public virtual ICollection<mensaje> mensajes { get; set; }
        public virtual ICollection<profesorfavorito> profesorfavoritoes { get; set; }
        public virtual ICollection<tutoria> tutorias { get; set; }
    }
}