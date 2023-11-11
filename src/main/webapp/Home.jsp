<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Advance Java</title>
    <link rel="stylesheet" href="style.css" />
    <style type="text/css">
    *{
    margin: 0;
    padding: 0;
    font-family: Georgia, 'Times New Roman', Times, serif;
}

/* Banner section start */
.top{
width: 100%;
height: 120px;
background-color: #59981A;
border: 1px solid black;
display: flex;
}

.tollfree{
    margin-top: 23px;
    margin-left: 330px;
    margin-bottom: 12px;
    padding: 20px;
    height: auto;
    width: auto;
    background-color: #d1de5c;
    border: 2px solid black;
    border-radius: 4%;
}
a{
    text-decoration: none;
    font-weight: bold;
    color: black;
    padding: 15px;
}
/* Banner section end */


/* Navbar start */
.nav-links{
    display: flex;
    align-items: center;
    background: #fff;
    padding: 20px 15px;
    border-radius: 12px;
    box-shadow: 0 5px 10px rgba(0,0,0,0.2);
  }
  .nav-links li{
    list-style: none;
    margin: 0 12px;
  }
  .nav-links li a{
    position: relative;
    color: #333;
    font-size: 18px;
    font-weight: 400;
    padding: 4px 0;
    text-decoration: none;
  }
  .nav-links li a:before{
    content: '';
    position: absolute;
    bottom: 0;
    left: 0;
    height: 3px;
    width: 0%;
    background: #81B622;
    border-radius: 12px;
    transition: all 0.4s ease;
  }
  .nav-links li a:hover:before{
    width: 100%;
  }
  .nav-links li.center a:before{
    left: 50%;
    transform: translateX(-50%);
  }
  .nav-links li.upward a:before{
    width: 100%;
    bottom: -5px;
    opacity: 0;
  }
  .nav-links li.upward a:hover:before{
    bottom: 0px;
    opacity: 1;
  }
  .nav-links li.forward a:before{
    width: 100%;
    transform: scaleX(0);
    transform-origin: right;
    transition: transform 0.4s ease;
  }
  .nav-links li.forward a:hover:before{
    transform: scaleX(1);
    transform-origin: left;
  }
  /* Navbar end */


  .count{
    height: 120px;
    width: 100%;
    background-color: #92b451;
    display: flex;
    justify-content: space-between;
    padding-top: 25px;
  }

  .number{
    text-align: center;
    font-size: large;
  }


  .content{
    height: auto;
    width: 100%;
    text-align: center;
    background-color: #a1b579;
  }
  .content h3{
    font-size: larger;
  }
  .content p{
    color: black;
    font-size: large;
    margin-left: 80px;
    margin-right: 80px;
    padding-top: 20px;
    padding-bottom: 20px;
  }


  .discussion{
    height: auto;
    width: 100%;
    text-align: center;
    background-color: #a4ac94;
  }
  .discussion h3{
    font-size: larger;
  }
  .discussion p{
    color: black;
    font-size: large;
    margin-left: 80px;
    margin-right: 80px;
    padding-top: 20px;
    padding-bottom: 20px;
  }
  .discussion span{
    font-size: larger;
    text-decoration: underline;
  }


  .search-results{
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
    max-width: 1200px;
    margin: 0 auto;
}

.search-result{
    margin-bottom: 60px;
    width: 320px;
    height: 100%;
    border-radius: 5px;
    /* box-shadow: 0 0 6px rgb(0, 0, 0.2); */
    overflow: hidden;
}
.search-result img{
    width: 100%;
    height: 100%;
    object-fit: cover;
    /* transition: opacity 0.2s ease-in-out; */
}
.search-result a{
    font-size: 20px;
    text-decoration: none;
    color:#333;
    display: block;
    padding: 10px;
    text-transform: capitalize;
}
.search-result button{
  background-color: #d1de5c;
font-size: 18px;
border: none;
color: #fff;
padding: 10px 20px;
text-align: center;
display: block;
margin: 30px auto;
border-radius: 5px;
cursor: pointer;
color: black;
font-weight: bold;
}

/* ask query section start */
form{
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 60px;
  justify-content: space-between;
  margin-left: 35%;
}

#ask_query{
  width: 60%;
  height: 60%;
  max-width: 400px;
  padding: 10px 20px;
  border: none;
  box-shadow: 0 0 6px rgba(0, 0, 0, 0.2);
  border-radius: 5px;
  font-size: 18px;
  color: #333;
}

#search-button{
  padding: 10px 20px;
  background-color: #d1de5c;
  color: black;
  border: none;
  font-size: 18px;
  box-shadow: 0 0 6px rgb(0, 0, 0.2);
  cursor: pointer;
  border-radius: 5px;
  margin-left: 10px;
}
/* Ask query section end */


.faq{
  background-color: #d7de96;
  font-size: 18px;
  border: none;
  color: #fff;
  padding: 10px 20px;
  text-align: center;
  display: block;
  margin: 30px auto;
  border-radius: 5px;
  cursor: pointer;
  color: black;
  font-weight: bold;
}


.image{
  max-width: 1200px;
    margin: 0 auto;
}
.image img{
  width: 100%;
    height: 100%;
    object-fit: cover;
}
    
    </style>
  </head>
  <body>
    <!-- Banner section start -->
    <nav class="top">
      <div class="image">
        E-Nasha Mukti Kendra
      </div>
      <div class="tollfree">
        <p>Toll free Deaddiction Helpline :</p>
        <a href="tel: 7848935854" target="_main"
          >+91-784-893-5854<i class="fab fa-phone"></i
        ></a>
      </div>
    </nav>
    <!-- Banner section end -->

    <!-- Navbar start -->
    <ul class="nav-links">
      <li><a href="#">HOME</a></li>
      <li class="center"><a href="#">About Us</a></li>
      <li class="upward"><a href="#">Gallery</a></li>
      <li class="forward"><a href="#">Take a Pledge</a></li>
      <li class="forward"><a href="#">Dashboard</a></li>
      <li class="forward"><a href="#">Forum and Discussion</a></li>
      <li class="forward"><a href="#">Volunteer Corner</a></li>
      <li>
        <div style="
          font-size: larger;
          color: #3d550c;
          border: 2px solid #3d550c;
          background-color: #ecf87f;
          border-radius: 10%;
          padding: 5px;
          margin-left: 280px;
        "
      >
        <a href="Login.jsp">Login</a>
        </div>
         <div style="
          display: inline-block; 
          font-size: larger;
          color: #3d550c;
          border: 2px solid #3d550c;
          background-color: #ecf87f;
          border-radius: 10%;
          padding: 5px;
          margin-left: 280px;
        "
      >
        <a href="Registration.jsp">Registration</a>
        </div>
      </li>
      
    </ul>
    <!-- Navbar end -->

    <div class="count">
      <div class="number">
        <img
          src="https://nmba.dosje.gov.in/assets/images/icons/c1.png"
          alt="Ayesha Singh"
        />
        <p>33657065 +</p>
        <span>Youth Reached Out</span>
      </div>
      <div class="number">
        <img
          src="https://nmba.dosje.gov.in/assets/images/icons/c2.png"
          alt="Anpam mitthal"
        />
        <p>22521641 +</p>
        <span>Women Reached Out</span>
      </div>
      <div class="number">
        <img
          src="https://nmba.dosje.gov.in/assets/images/icons/c3.png"
          alt="Shraddha khapra : Co-founder-Apna College"
        />
        <p>326565 +</p>
        <span>Educational Institutions Covered</span>
      </div>
      <div class="number">
        <img
          src="https://nmba.dosje.gov.in/assets/images/icons/c4.png"
          alt="Shraddha khapra : Co-founder-Apna College"
        />
        <p>106445472 +</p>
        <span>Total People Reached Out</span>
      </div>
    </div>

    <div class="content">
      <h3>Welcome to Nasha Mukt Bharat Abhiyaan</h3>
      <p>
        Ministry of Social Justice & Empowerment which is the Nodal Ministry for
        Drug Demand Reduction has formulated and launched Nasha Mukt Bharat
        Abhiyaan (NMBA) on 15th August 2020, in 272 Districts across 32
        State/Union Territories identified as most vulnerable in terms of usage
        of drugs in the country. These vulnerable districts were identified on
        the basis of findings from the Comprehensive National Survey and the
        inputs provided by the Narcotics Control Bureau (NCB).
      </p>
    </div>

    <div class="discussion">
      <h3>Forum & Discussion</h3>
      <p>
        Have a question related to substance/drug use and its related topics
        <span>Ask a question to our experts</span>
      </p>

      <div class="search-results">
        <div class="search-result">
          <img
            src="https://nmba.dosje.gov.in/uploads/profile/1_544849_Seema%20Uthaman.jpg"
            alt=""
          />
          <a href="#" target="_blank">Vice Principal. IMHANS,Calicat</a>
        </div>
        <div class="search-result">
          <img
            src="https://nmba.dosje.gov.in/uploads/profile/1_113463_IMG-20211007-WA0005.jpg"
            alt=""
          />
          <a href="#" target="_blank"
            >Associate Professor (Clinical Psychology), Dept. of Psychiatry.
            PGIMER, Chandigarh</a
          >
        </div>
        <div class="search-result">
          <img
            src="https://nmba.dosje.gov.in/uploads/profile/1_763998_IMG-20211011-WA0008.jpg"
            alt=""
          />
          <a href="#" target="_blank"
            >Clinical psychologist, former scholar. NIMHANS</a
          >
        </div>
        <form action="">
          <input
            type="text"
            id="ask_query"
            placeholder="Ask your Query here."
          />
          <button id="search-button">Submit</button>
        </form>
      </div>
      <div class="faq">
        <a href="https://nmba.dosje.gov.in/faqDetails.php">FAQ's</a>
      </div>
    </div>

    <div class="image">
      <img src="nasha.png" alt="random image" />
    </div>
  </body>
</html>