<template>
<div>
    <user-details v-bind:userId="parseInt($route.params.userId)" />
    <div id="manager">
    <button>Manage Band</button></div><br>
    <h1 class="user-inbox">Inbox</h1>
    <div class="inbox-content">
    <message-list />
    </div>
    
    <br>
    <h1 class="band-list">Followed Bands</h1>
    </div>
</template>
<!--
//uses userDetails component
//profile info --&picture? 
//need to have a message section -- date descending
// sort button, by band/date
-->
<script>
import MessageList from "../components/MessageList.vue";
import UserDetails from "../components/UserDetails.vue";
export default {
  components: { UserDetails, MessageList },
};
</script>
<style>
.inbox-content {
  text-align: center;
}
#manager {
  text-align: center;
}
</style>
