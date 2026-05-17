<script setup>
import { ref, watch, onMounted } from 'vue'
import { treeService, quadrilleService, statusService, pruningTypeService } from '@/services'

const selectedEntity = ref('personas')
const columns = ref([])
const data = ref([])
const loading = ref(false)
const error = ref(null)

// Entidades sin endpoint en el backend — datos estáticos
const staticData = {
  personas: [
    { nombre: 'Danilo Cordoba', documento: 'CC', numeroDocumento: '1111111111', fechaNacimiento: '5/21/1998', direccion: 'Vereda las Cuchillas', telefono: '1111111111', email: 'danilo.cordoba9497@uco.net.co' },
    { nombre: 'Michel Guarnizo', documento: 'CC', numeroDocumento: '2222222222', fechaNacimiento: '12/28/2002', direccion: 'Cra 29 # 40-82', telefono: '0000000000', email: 'michel.guarnizo2701@uco.net.co' },
    { nombre: 'Danilo Cordoba', documento: 'CC', numeroDocumento: '2222222222', fechaNacimiento: '5/23/1998', direccion: 'AV 38 C # 40-50', telefono: '3333333333', email: 'juan.grisales2711@uco.net.co' },
  ],
  sector: [
    { nombre: 'Porvenir Tercera Etapa', municipio: 'Rionegro-Antioquia-Colombia' },
    { nombre: 'El porvenir comuna 4 villa manuela', municipio: 'Rionegro-Antioquia-Colombia' },
    { nombre: 'El centro comuna 3 avenida galan', municipio: 'Rionegro-Antioquia-Colombia' },
    { nombre: 'San Antonio comuna 1 san bartolo', municipio: 'Rionegro-Antioquia-Colombia' },
    { nombre: 'Santa ana comuna 2 altos de la Pereira', municipio: 'Rionegro-Antioquia-Colombia' },
  ],
  familia: [
    { nombreCientifico: 'Araucaria heterophylla', nombreComun: 'Araucaria' },
    { nombreCientifico: 'Syzygium paniculata', nombreComun: 'Eugenia' },
    { nombreCientifico: 'Archontophoenix cunninghamiana', nombreComun: 'Palma payanesa' },
    { nombreCientifico: 'Inga sp', nombreComun: 'Inga' },
    { nombreCientifico: 'Handroanthus chrysanthus', nombreComun: 'Guayacán amarillo' },
  ],
  herramienta: [
    { nombre: 'Pala', descripcion: 'Herramienta manual utilizada para cavar y mover tierra.' },
    { nombre: 'Tijera', descripcion: 'Herramienta manual utilizada para realizar cortes en ramas delgadas y hojas.' },
    { nombre: 'Pico', descripcion: 'Herramienta de mano con punta metalica empleada para remover tierra dura.' },
    { nombre: 'Escalera', descripcion: 'Estructura portatil para acceder a ramas de diferentes alturas.' },
    { nombre: 'Arnes', descripcion: 'Equipo de proteccion personal para podas en altura.' },
  ],
}

// Entidades que cargan desde la API
const apiFetchers = {
  arbol: () => treeService.getAll(),
  cuadrilla: () => quadrilleService.getAll(),
  estado: () => statusService.getAll(),
  tipo: () => pruningTypeService.getAll(),
}

const apiCache = {}

const flattenRow = (row) => {
  const flat = {}
  for (const [key, value] of Object.entries(row)) {
    if (value !== null && typeof value === 'object' && !Array.isArray(value)) {
      for (const [subKey, subValue] of Object.entries(value)) {
        flat[`${key}.${subKey}`] = subValue
      }
    } else {
      flat[key] = value
    }
  }
  return flat
}

const loadEntity = async (entity) => {
  error.value = null

  if (staticData[entity]) {
    data.value = staticData[entity]
    columns.value = Object.keys(data.value[0] ?? {})
    return
  }

  if (apiCache[entity]) {
    data.value = apiCache[entity]
    columns.value = Object.keys(data.value[0] ?? {})
    return
  }

  loading.value = true
  try {
    const response = await apiFetchers[entity]()
    const rows = (response.data ?? []).map(flattenRow)
    apiCache[entity] = rows
    data.value = rows
    columns.value = Object.keys(rows[0] ?? {})
  } catch (err) {
    error.value = err.message
    data.value = []
    columns.value = []
  } finally {
    loading.value = false
  }
}

onMounted(() => loadEntity(selectedEntity.value))
watch(selectedEntity, (entity) => loadEntity(entity))
</script>

<template>
  <div class="container mt-4">
    <h4 class="mb-3">Gestion de informacion</h4>

    <select v-model="selectedEntity" class="form-select mb-3">
      <option value="personas">Personas</option>
      <option value="sector">Sectores</option>
      <option value="familia">Familia de arboles</option>
      <option value="arbol">Arboles</option>
      <option value="herramienta">Herramientas</option>
      <option value="cuadrilla">Cuadrillas</option>
      <option value="estado">Estados</option>
      <option value="tipo">Tipos de poda</option>
    </select>

    <div v-if="loading" class="text-center py-4">
      <div class="spinner-border text-success" role="status">
        <span class="visually-hidden">Cargando...</span>
      </div>
    </div>

    <div v-else-if="error" class="alert alert-danger">
      Error al cargar datos: {{ error }}
    </div>

    <div v-else-if="data.length === 0" class="alert alert-info">
      No hay registros disponibles.
    </div>

    <table v-else class="table table-striped table-bordered table-hover">
      <thead class="table-dark">
        <tr>
          <th v-for="col in columns" :key="col">{{ col }}</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(row, index) in data" :key="index">
          <td v-for="col in columns" :key="col">{{ row[col] }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
