﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace API.Models
{
    public class profesorApp
    {
        public int idprofesor { get; set; }
        public string nombre { get; set; }
        public string apellido { get; set; }
        public string password { get; set; }
        public string email { get; set; }
        public string celular { get; set; }
        public string descripcion { get; set; }
        public Nullable<decimal> preciomin { get; set; }
        public Nullable<decimal> preciomax { get; set; }
        public string experiencia { get; set; }
        public Nullable<int> calificacion { get; set; }
        public Nullable<int> dni { get; set; }
        public string antecedentes { get; set; }
        public string fotourl { get; set; }
        public Nullable<int> id_metodopago { get; set; }

    }
}