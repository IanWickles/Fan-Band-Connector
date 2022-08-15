<template>
<div>
    <user-details v-bind:userId="parseInt($route.params.userId)" />
    <div id="manager">
    <button>Manage Band</button></div><br>
    <h1 class="user-inbox">Inbox</h1>
    <div class="inbox-content">
    <message-list />
     <button>Read</button> | <button>Delete</button>
    <br>
    Blah blah blah from Blah blah | <button>Read</button> | <button>Delete</button><br>
    Blah blah blah from Blah blah | <button>Read</button> | <button>Delete</button>
    
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
<<<<<<< HEAD
<style>
.inbox-content {
  text-align: center;
}
#manager {
  text-align: center;
}
</style>
=======

<style></style>
>>>>>>> 73b752da4074846a8edd17544b06454db1149cd2
