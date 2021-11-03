


const app = Vue.createApp({
  data() {
    return {
      products: [],
      buy: {},
    }

  },

  created() {
    axios.get('/api/products')
      .then(res => {
        this.products = res.data
        console.log("holamundo")
      }).catch(res => console.log("bye world"))

  },

  methods: {
    buyPhone(phones) {
      console.log(phones.id)
      var myHeaders = new Headers();
      myHeaders.append("x-integrator-id", "dev_24c65fb163bf11ea96500242ac130004");
      myHeaders.append("Authorization", "Bearer APP_USR-6317427424180639-042414-47e969706991d3a442922b0702a0da44-469485398");
      myHeaders.append("Content-Type", "application/javascript");

      var raw = `{
                "items": [
                  {
                      "id": "`+ phones.id + `",
                    "title": "`+ phones.name + `",
                    "description": "`+ phones.description + `",
                    "picture_url": "`+ phones.imgUrl + `",
                    "quantity": `+ phones.stock + `,
                    "unit_price": `+ phones.price + `,
                  }
                ],
                "payer": {
                  "name": "Lalo"
                  "surname": "Landa"
                  "email": "test_user_63274575@testuser.com"
                  "phone": {
                      "area_code": 11,
                      "number": 22223333,
                  },
                  "identification": {},
                  "address": {
                      "street_name":"Calle Falsa",
                      "street_number": "123",
                      "zip_code": "111",
                  }
                },
                "payment_methods": {
                  "excluded_payment_methods": [
                    {
                        "id": "amex"}
                  ],
                  "excluded_payment_types": [
                    {
                        "id": "atm"}
                  ],
                  "installments" : 6,
                },
                auto_return : "approved", 
                "back_urls": {
                  "failure": "https://integrationmpalpha.herokuapp.com/web/index.html",
                  "pending": "https://integrationmpalpha.herokuapp.com/web/index.html",
                  "success": "https://integrationmpalpha.herokuapp.com/web/index.html",
                },
                 "external_reference": "sebastiandavidgraff@gmail.com",

              }`;


      var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
      };

      fetch("https://api.mercadopago.com/checkout/preferences", requestOptions)
        .then(response => response.json())
        .then(result => window.location.href = result.init_point)
        .catch(error => console.log('error', error));


    }
  },
})


app.mount("#app")