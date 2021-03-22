@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( 
  classes = {WebConfig.class, PersistenceConfig.class},
  loader = AnnotationConfigContextLoader.class)
public class SpringContextIntegrationTest {

   @Test
   public void contextLoads(){
      // When
   }
}
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerAppIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenTestApp_thenEmptyResponse() throws Exception {
        this.mockMvc.perform(get("/users")
            .andExpect(status().isOk()));
           //.andExpect(...);
    }

}

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerWebLayerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;

    @Test()
    public void whenTestMvcController_thenRetrieveExpectedResult() throws Exception {
        // ...

        this.mockMvc.perform(get("/users"));
         //   .andExpect(...);
    }
}