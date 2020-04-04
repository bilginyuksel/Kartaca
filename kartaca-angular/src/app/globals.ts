import { User }  from './user';

// First initialization for currentUser.
// It can be remove if you create an api request to fetch user data.
export let currentUser : User = {username:'', token:'', id:-1, exp:-1,email:''};