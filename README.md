Bloggr is a simple blogging application implemented in Spring 4 using Bootstrap to power the front end.

The goal of this project is to successfully create a blogging environment.

Aim is to have the following functionalities:

<ul>
  <li>Home</li>
  <li>View / Create / Edit / Delete Posts</li>
  <li>View Users</li>
  <li>Register</li>
  <li>Login</li>
  <li>Logout</li>
  <li>RESTful API</li>
</ul>

API endpoints:

GET/POST <i>/api/blogs</i>

<code>

    {
        "title": "Title",
        "message": "Message"
    }
    
</code>

GET/PUT/DELETE <i>/api/blog/{blogTitle}</i>


<code>

    {
        "id": 3,
        "title": "Title",
        "message": "Message",
        "blogger": {
            "id": 1,
            "username": "milos",
            "password": "milos",
            "firstName": "Milos",
            "lastName": "Brajevic",
            "createdAt": 1515581395000,
            "enabled": 1
        },
        "createdAt": 1515615105000,
        "link": "title"
    }

</code>