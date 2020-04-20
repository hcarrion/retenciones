package pe.confianza.retenciones.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
* @Grupo: Retenciones
* @author: HARRY CARRION, JUAN SALAZAR, ANGEL LLANCO
* @Fecha: 03/04/2020
**/
@Entity
@Table(name = "PANTALLA", catalog = "canales", schema = "public")
public class Pantalla implements Serializable {

		private static final long serialVersionUID = 1L;
		@Id
		@NotNull
		@TableGenerator(name = "TBPantallaCorr", table = "CORRELATIVOS01", pkColumnName = "descripcion", valueColumnName = "correlativo", pkColumnValue = "CODIGO_PANTALLA", initialValue = 10, allocationSize = 1, schema = "public")
		@GeneratedValue(strategy = GenerationType.TABLE, generator = "TBPantallaCorr")
		@Column(name = "idPantalla", nullable = false)
		private Integer idPantalla;
		@Size(max = 250)
		@Column(name = "descripcion", length = 150)
		private String descripcion;
		@Size(max = 120)
		@Column(name = "estado", length = 1)
		private String estado;

		@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPantalla")
		private List<Solicitudes> solicitudesList;

		public Pantalla() {
		}

		public Pantalla(Integer idPantalla) {
			this.idPantalla = idPantalla;
		}

		public Integer getIdpantalla() {
			return idPantalla;
		}

		public void setIdCarta(Integer idPantalla) {
			this.idPantalla = idPantalla;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getestado() {
			return estado;
		}

		public void setestado(String estado) {
			this.estado = estado;
		}

		
		@XmlTransient
		public List<Solicitudes> getSolicitudesList() {
			return solicitudesList;
		}

		public void setSolicitudesList(List<Solicitudes> solicitudesList) {
			this.solicitudesList = solicitudesList;
		}

		@Override
		public int hashCode() {
			int hash = 0;
			hash += (idCarta != null ? idCarta.hashCode() : 0);
			return hash;
		}

		@Override
		public boolean equals(Object object) {
			// TODO: Warning - this method won't work in the case the id fields are not set
			if (!(object instanceof Cartas)) {
				return false;
			}
			Cartas other = (Cartas) object;
			if ((this.idCarta == null && other.idCarta != null)
					|| (this.idCarta != null && !this.idCarta.equals(other.idCarta))) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return "com.opensys.pruebaposgret001.Cartas[ idCarta=" + idCarta + " ]";
		}

	}
