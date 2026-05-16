<script setup>
import { ref, watch } from 'vue'

// Entidad seleccionada
const selectedEntity = ref('personas')

// Datos simulados (mock)
const mockData = {
  personas: [
    { nombre: 'Danilo Cordoba', documento: 'CC', numeroDocumento: '1111111111', fechaNacimiento: '5/21/1998',direccion: 'Vereda las Cuchillas', telefono: '1111111111', email: 'danilo.cordoba9497@uco.net.co' },
    { nombre: 'Michel Guarnizo ', documento: 'CC', numeroDocumento: '2222222222', fechaNacimiento: '12/28/2002',direccion: 'Cra 29 # 40-82', telefono: '0000000000', email: 'michel.guarnizo2701@uco.net.co' },
    { nombre: 'Danilo Cordoba', documento: 'CC', numeroDocumento: '2222222222', fechaNacimiento: '5/23/1998',direccion: 'AV 38 C # 40-50', telefono: '3333333333', email: 'juan.grisales2711@uco.net.co' },
  ],
  sector: [
    { nombre: 'Porvenir Tercera Etapa', municipio: 'Rionegro-Antioquia-Colombia' },
    { nombre: 'El porvenir comuna 4 villa manuela', municipio: 'Rionegro-Antioquia-Colombia' },
    { nombre: 'El centro comuna 3 avenida galan', municipio: 'Rionegro-Antioquia-Colombia' },
    { nombre: 'San Antonio comuna 1 san bartolo', municipio: 'Rionegro-Antioquia-Colombia' },
    { nombre: 'Santa ana comuna 2 altos de la Pereira', municipio: 'Rionegro-Antioquia-Colombia' },
  ],
  familia: [
    { nombreCientifico: 'Araucaria heterophylla', nombreComun: 'Araucaria'},
    { nombreCientifico: 'Syzygium paniculata', nombreComun: 'Eugenia'},
    { nombreCientifico: 'Archontophoenix cunninghamiana', nombreComun: 'Palma payanesa'},
    { nombreCientifico: 'Inga sp', nombreComun: 'Inga'},
    { nombreCientifico: 'Handroanthus chrysanthus', nombreComun: 'Guayacán amarillo'},
  ],
  arbol: [
    { Especie: 'Araucaria heterophylla', Sector: 'El porvenir comuna 4 villa manuela-Rionegro-Antioquia-Colombia', Longitud: '-75.382563', Latitud: '6.145493' },
    { Especie: 'Syzygium paniculata', Sector: 'El porvenir comuna 4 villa manuela-Rionegro-Antioquia-Colombia', Longitud: '-75.382687', Latitud: '6.145503' },
    { Especie: 'Archontophoenix cunninghamiana', Sector: 'El porvenir comuna 4 villa manuela-Rionegro-Antioquia-Colombia', Longitud: '-75.382467', Latitud: '6.148721' },
    { Especie: 'Inga sp', Sector: 'El centro comuna 3 avenida galan-Rionegro-Antioquia-Colombia', Longitud: '-75.375115', Latitud: '6.148722' },
    { Especie: 'Handroanthus chrysanthus', Sector: 'El centro comuna 3 avenida galan-Rionegro-Antioquia-Colombia', Longitud: '-75.375177', Latitud: '6.148721' },
  ],
  herramienta: [
    { nombre: 'Pala', descripcion: 'Herramienta manual utilizada para cavar y mover tierra.'},
    { nombre: 'Tijera', descripcion: 'Herramienta manual utilizada para realizar cortes en ramas delgadas y hojas.'},
    { nombre: 'Pico', descripcion: 'Herramienta de mano con punta metalica empleada para remover tierra dura, raices superficiales o preparar el terreno alrededor del arbol.'},
    { nombre: 'Escalera', descripcion: 'Estructura portatil que le permite al personal acceder a ramas de diferentes alturas para realizar el proceso de poda de manera segura.'},
    { nombre: 'Arnes', descripcion: 'Equipo de proteccion personal utilizado para asegurar al operario durante las podas en altura, evitando caidas y accidentes.'},
  ],
  cuadrilla: [
    { nombreCuadrilla: 'E-001', encargado: 'CC-1017259497'},
    { nombreCuadrilla: 'E-002', encargado: 'CC-1000442701'},
    { nombreCuadrilla: 'E-003', encargado: 'CC-2222222222'},
  ],
  estado: [
    { nombre: 'Abierto'},
    { nombre: 'En ejecucion'},
    { nombre: 'Cerrado'},
  ],
  tipo: [
    { nombre: 'Preventivo'},
    { nombre: 'Correctivo'},
  ],
}

// Columnas y filas reactivas
const columns = ref([])
const data = ref([])

// Función para cargar datos según la entidad seleccionada
const loadData = () => {
  data.value = mockData[selectedEntity.value]
  columns.value = Object.keys(data.value[0])
}

// Cargar datos iniciales
loadData()

// Actualizar cuando cambie la entidad seleccionada
watch(selectedEntity, loadData)
</script>

<template>
  <div class="container mt-4">
    <h4 class="mb-3">Gestion de informacion</h4>

    <!-- Selector de entidad -->
    <select v-model="selectedEntity" class="form-select mb-3">
      <option value="personas">Personas</option>
      <option value="sector">Sectores</option>
      <option value="familia">Familia de arboles</option>
      <option value="arbol">Arboles</option>
      <option value="herramienta">Herramientas</option>
      <option value="cuadrilla">Cuadrillas</option>
      <option value="estado">Estados</option>
      <option value="tipo">Tipos</option>
    </select>

    <!-- Tabla -->
    <table class="table table-striped table-bordered table-hover">
      <thead>
        <tr>
          <th v-for="col in columns" :key="col">{{ col }}</th>
        </tr>
      </thead>
      <tbody>
        <tr class="table table-active" v-for="(row, index) in data" :key="index">
          <td v-for="col in columns" :key="col">
            {{ row[col] }}
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

