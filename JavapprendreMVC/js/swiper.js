/*var mySwiper = new Swiper ('.swiper-container', {
    // Optional parameter
    slidesPerView : 2,
    centeredSlides : true,
    longSwipes: false,
    effect : 'coverflow',
    rotate: 0,
    coverflow: {
              rotate: 0,
              stretch: 0,
              depth: 300,
              modifier: 3,
              slideShadows : true
          },
    
     
    // If we need pagination
    pagination: '.swiper-pagination', 
        //clickable: true, },
     
    // Navigation arrows
    nextButton: '.swiper-button-next',
    prevButton: '.swiper-button-prev',
    }) 
*/


var mySwiper = new Swiper('.swiper-container' , {
  slidesPerView : 2,
  centeredSlides : true,
  longSwipes: false,
  effect : 'coverflow',
  coverflowEffect: {
    rotate: 0,
    stretch: 0,
    depth: 300,
    modifier: 3,
    slideShadows: true

  },

  pagination: {
    el: '.swiper-pagination',
    clickable: true,
    renderBullet: function (index, className) {
        return '<span class= "swiper-pagination-bullet"></span>';
      },
  },

  navigation: {
    nextEl: '.swiper-button-next',
    prevEl: '.swiper-button-prev',
  },

})