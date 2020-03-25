export class MenuJson {
     menu = [
        {
          menunombre: 'Solicitud',
          menuicono: 'recent_actors',
          menuruta: 'solicitud'
        },
        {
          menunombre: 'Configuracion',
          menuicono: 'recent_actors',
          menuruta: 'solicitud',
          children: [
            {
              menunombre: 'Perfil y Funciones',
              menuicono: 'group',
              menuruta: 'perfil'
            },
            {
              menunombre: 'Pantalla',
              menuicono: 'speaker_notes',
              menuruta: 'pantalla'
            },
            {
              menunombre: 'Usuario',
              menuicono: 'feedback',
              menuruta: 'usuario'
            }
          ]
        }
      ];
}

