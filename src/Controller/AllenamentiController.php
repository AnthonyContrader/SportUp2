<?php
  namespace App\Controller;

  use App\Entity\Allenamenti;

  use Symfony\Component\HttpFoundation\Response;
  use Symfony\Component\HttpFoundation\Request;
  use Symfony\Component\Routing\Annotation\Route;
  use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
  use Symfony\Bundle\FrameworkBundle\Controller\Controller;

  use Symfony\Component\Form\Extension\Core\Type\TextType;
  use Symfony\Component\Form\Extension\Core\Type\TextareaType;
  use Symfony\Component\Form\Extension\Core\Type\SubmitType;

  class AllenamentiController extends Controller {
    /**
     * @Route("/", name="allenamenti_list")
     * @Method({"GET"})
     */
    public function index() {

      $allenamenti= $this->getDoctrine()->getRepository(Allenamenti::class)->findAll();

      return $this->render('allenamenti/index.html.twig', array('allenamenti' => $allenamenti));
    }

    /**
     * @Route("/allenamenti/new", name="new_allenamento")
     * Method({"GET", "POST"})
     */
    public function new(Request $request) {
      $allenamento = new Allenamenti();

      $form = $this->createFormBuilder($allenamento)
        ->add('allenamento', TextType::class, array('attr' => array('class' => 'form-control')))
        ->add('info', TextareaType::class, array(
          'required' => false,
          'attr' => array('class' => 'form-control')
        ))
        
        ->add('save', SubmitType::class, array(
          'label' => 'Create',
          'attr' => array('class' => 'btn btn-primary mt-3')
        ))
        ->getForm();

      $form->handleRequest($request);

      if($form->isSubmitted() && $form->isValid()) {
        $allenamento = $form->getData();

        $entityManager = $this->getDoctrine()->getManager();
        $entityManager->persist($allenamento);
        $entityManager->flush();

        return $this->redirectToRoute('allenamenti_list');
      }

      return $this->render('allenamenti/new.html.twig', array(
        'form' => $form->createView()
      ));
    }

    /**
     * @Route("/allenamenti/edit/{id}", name="edit_allenamento")
     * Method({"GET", "POST"})
     */
    public function edit(Request $request, $id) {
      $allenamento = new Allenamenti();
      $allenamento = $this->getDoctrine()->getRepository(Allenamenti::class)->find($id);

      $form = $this->createFormBuilder($allenamento)
        ->add('allenamento', TextType::class, array('attr' => array('class' => 'form-control')))
        ->add('info', TextareaType::class, array(
          'required' => false,
          'attr' => array('class' => 'form-control')
        ))
        
        ->add('save', SubmitType::class, array(
          'label' => 'Update',
          'attr' => array('class' => 'btn btn-primary mt-3')
        ))
        ->getForm();

      $form->handleRequest($request);

      if($form->isSubmitted() && $form->isValid()) {

        $entityManager = $this->getDoctrine()->getManager();
        $entityManager->flush();

        return $this->redirectToRoute('allenamenti_list');
      }

      return $this->render('allenamenti/edit.html.twig', array(
        'form' => $form->createView()
      ));
    }

    /**
     * @Route("/allenamenti/{id}", name="allenamento_show")
     */
    public function show($id) {
      $allenamento = $this->getDoctrine()->getRepository(Allenamenti::class)->find($id);

      return $this->render('allenamenti/show.html.twig', array('allenamento' => $allenamento));
    }

    /**
     * @Route("/allenamenti/delete/{id}")
     * @Method({"DELETE"})
     */
    public function delete(Request $request, $id) {
      $allenamenti = $this->getDoctrine()->getRepository(Allenamenti::class)->find($id);

      $entityManager = $this->getDoctrine()->getManager();
      $entityManager->remove($allenamenti);
      $entityManager->flush();

      $response = new Response();
      $response->send();
    }

    
  }
