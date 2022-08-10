<template>
  <div class="container is-fluid" id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }"><h1 class="title">Home</h1></router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>
