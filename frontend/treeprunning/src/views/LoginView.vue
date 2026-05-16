<template>
  <div>
    <img src="../assets/arbol.png" alt="Tree Prunning Logo" width="200" />
  </div>
  <div>
    <form @submit.prevent="login">
      <h2>Inicio de sesion</h2>
      <input v-model="username" placeholder="Nombre de usuario" required />
      <input v-model="password" type="password" placeholder="Contraseña" required />
      <button type="submit">Enviar</button>
    </form>
  </div>

</template>

<script setup>
import { ref } from 'vue'

const username = ref('')
const password = ref('')

function login() {
  // Dummy login logic
  if (username.value && password.value) {
    // In real app, validate credentials
    emit('login-success')
  } else {
    alert('Invalid credentials')
  }
}

const emit = defineEmits(['login-success'])
</script>

<style scoped>
div img {
  display: flex;
  margin: 20px auto;
  border-radius: 50%;
}
form {
  max-width: 320px;
  margin: 100px auto;
  padding: 32px;
  border: 1px solid #ccc;
  border-radius: 10px;
  background: #F5F5F5;
}
input {
  margin-top: 10px;
  display: block;
  width: 100%;
  border-radius: 10px;
  padding: 8px;
  margin-bottom: 16px;
}
button {
  width: 100%;
  padding: 10px;
  background: #2c3e50;
  color: #fff;
  border: none;
  border-radius: 4px;
  border: 1px solid #ccc;
  border-radius: 10px;
}
</style>
